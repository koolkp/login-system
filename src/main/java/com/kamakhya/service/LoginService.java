package com.kamakhya.service;

import com.kamakhya.dao.*;
import com.kamakhya.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILoginService {

    @Autowired
    IPermissionDao permissionDao;

    @Autowired
    IRoleDao roleDao;

    @Autowired
    IUserDao userDao;

    @Autowired
    IActionTypeDao actionTypeDao;

    @Autowired
    IResourceDao resourceDao;

    public boolean hasPermission(int userId, int actionTypeId, int resourceId) {

        List<Permission> permissions = permissionDao.getPermissionByActionTypeAndResource(actionTypeId, resourceId);
        for (Permission permission : permissions) {
            List<Role> role = roleDao.getRoleByPermissionAndUser(permission.getId(), userId);
            if (role != null && role.size() > 0)
                return true;
        }
        return false;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public void add(ActionType actionType) {
        actionTypeDao.add(actionType);
    }

    public void add(Resource resource) {
        resourceDao.add(resource);
    }

    public void add(Permission permission) {
        permissionDao.add(permission);
    }

    public void add(Role role) {
        roleDao.add(role);
    }
}
