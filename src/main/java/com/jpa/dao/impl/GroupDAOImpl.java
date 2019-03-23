package com.jpa.dao.impl;

import com.jpa.dao.GroupDAO;
import com.jpa.model.Group;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class GroupDAOImpl implements GroupDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Group addGroup(Group group) {
        entityManager.persist(group);
        return group;
    }

    @Override
    public Group getGroup(int id) {
        return entityManager.find(Group.class, id);
    }
}
