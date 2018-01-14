package com.kamakhya.dao;

import com.kamakhya.entity.Resource;
import com.kamakhya.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class ResourceDao implements IResourceDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Resource resource) {
        entityManager.persist(resource);
    }
}
