package com.smart.elearning.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smart.elearning.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
    Optional<AppUser> findByUsername(String username);
    List<AppUser> findByUsernameContains(String username);
    Optional<AppUser> findByEmail(String email);
}
