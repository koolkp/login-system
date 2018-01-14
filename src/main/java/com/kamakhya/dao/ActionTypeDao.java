package com.kamakhya.dao;

import com.kamakhya.entity.ActionType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class ActionTypeDao implements IActionTypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(ActionType actionType) {
        entityManager.persist(actionType);
    }

}
