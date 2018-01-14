package com.kamakhya.dao;

import com.kamakhya.entity.Role;

import java.util.List;

public interface IRoleDao {

    public List<Role> getRoleByPermissionAndUser(int permissionId, int userId);

    public void add(Role role);
}
