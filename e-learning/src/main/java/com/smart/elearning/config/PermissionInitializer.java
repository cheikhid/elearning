package com.smart.elearning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.smart.elearning.dao.UserRepository;
import com.smart.elearning.dao.PermissionRepository;
import com.smart.elearning.dao.RoleRepository;
import com.smart.elearning.entity.AppUser;
import com.smart.elearning.entity.Permission;
import com.smart.elearning.entity.Role;
//import com.smart.elearning.dao.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Component
public class PermissionInitializer implements ApplicationRunner {

    @Autowired
    private final PermissionRepository permissionRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private UserRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PermissionInitializer(PermissionRepository permissionRepository, RoleRepository roleRepository,
            UserRepository userInfoRepository,
            PasswordEncoder passwordEncoder) {
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] perm_list = { "list_role", "view_role", "create_role", "update_role", "delete_role",
                "list_permission", "view_permission", "create_permission", "update_permission", "delete_permission",
                "list_user", "update_user_password", "update_user_role", "delete_user", "list_account", "view_account","create_permission", 
                "update_user_password", "get_profile", "update_profile","create_company","view_company","list_cours","list_all_cours","create_cours",
                "list_all_users","create_user","list_user","update_user","view_user_abonnements",
                "update_abonnements","create_abonnements","list_all_abonnements","list_abonnements"
        };

        for (String perm : perm_list) {
            createPermissionIfNotFound(perm);
        }

        createSuperAdminRole("super_admin");
        createSuperUser("admin", "admin", "admin@admin.com");
    }

    @Transactional
    public void createPermissionIfNotFound(String name) {
        if (!permissionRepository.existsByName(name)) {
            Permission permission = new Permission();
            permission.setName(name);
            permissionRepository.save(permission);
        }
    }

    @Transactional
    public void createSuperUser(String username, String password, String email) {
        Optional<AppUser> user1 = userInfoRepository.findByUsername(username);
        Optional<AppUser> user2 = userInfoRepository.findByEmail(email);
        if (user1.isPresent() || user2.isPresent()) {
            AppUser user = user1.isPresent() ? user1.get() : user2.get();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(roleRepository.findByName("super_admin"));
            userInfoRepository.save(user);
        } else {
            AppUser user = new AppUser();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            //user.setRole(roleRepository.findByName("super_admin"));
            user.setRole(roleRepository.findByName("super_admin"));
            user.setEmail(email);
            userInfoRepository.save(user);
        }
    }

    @Transactional
    public void createSuperAdminRole(String name) {
        Role superAdminRole = roleRepository.findByName(name);
        if (superAdminRole == null) {
            // Create new super admin role if it does not exist
            superAdminRole = new Role();
            superAdminRole.setName(name);
            superAdminRole.setPermissions(permissionRepository.findAll());
            roleRepository.save(superAdminRole);
        } else {
            // Update existing super admin role by adding super user permission
            superAdminRole.setPermissions(permissionRepository.findAll());
            roleRepository.save(superAdminRole);
        }
    }

}