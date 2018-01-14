package com.kamakhya.dao;

import com.kamakhya.entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RoleDao implements IRoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Role role) {
        entityManager.persist(role);
    }

    public List<Role> getRoleByPermissionAndUser(int permissionId, int userId) {
        String hql = "FROM Role as rol WHERE rol.permissionId = ? and rol.userId = ?";
        return entityManager.createQuery(hql).setParameter(1, permissionId)
                .setParameter(2, userId).getResultList();
    }
}

