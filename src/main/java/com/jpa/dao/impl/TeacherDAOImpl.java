package com.jpa.dao.impl;

import com.jpa.dao.TeacherDAO;
import com.jpa.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class TeacherDAOImpl implements TeacherDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher getTeacher(int id) {
        return entityManager.find(Teacher.class, id);
    }
}
