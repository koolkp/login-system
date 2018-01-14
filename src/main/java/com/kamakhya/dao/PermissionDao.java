package com.kamakhya.dao;

import com.kamakhya.entity.Permission;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermissionDao implements IPermissionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Permission permission) {
        entityManager.persist(permission);
    }

    public List<Permission> getPermissionByActionTypeAndResource(int actionTypeId, int resourceId) {
        String hql = "FROM Permission as per WHERE per.actionTypeId = ? and per.resourceId = ?";
        return entityManager.createQuery(hql).setParameter(1, actionTypeId)
                .setParameter(2, resourceId).getResultList();
    }
}
