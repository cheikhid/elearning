package com.smart.elearning.service;

import java.util.List;

import com.smart.elearning.entity.Permission;


public interface PermissionServices {
    
    public List<Permission> getAllPermissions();

    public Permission createPermission(Permission permission);

    public Permission getPermissionById(long id);

    public Permission updatePermission(long id, Permission updatedPermission);

    public Boolean deletePermission(long id);
}