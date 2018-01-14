package com.kamakhya.dao;

import com.kamakhya.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class UserDao implements IUserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }
}
