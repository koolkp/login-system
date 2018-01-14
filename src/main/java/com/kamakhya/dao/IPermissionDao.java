package com.kamakhya.dao;

import com.kamakhya.entity.Permission;

import java.util.List;

public interface IPermissionDao {
    public List<Permission> getPermissionByActionTypeAndResource(int actionTypeId, int resourceId);

    public void add(Permission permission);
}
