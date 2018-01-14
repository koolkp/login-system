package com.kamakhya.service;

import com.kamakhya.entity.*;

public interface ILoginService {

    public boolean hasPermission(int userId, int actionTypeId, int resourceId);

    public void add(User user);

    public void add(ActionType actionType);

    public void add(Resource resource);

    public void add(Permission permission);

    public void add(Role role);

}
