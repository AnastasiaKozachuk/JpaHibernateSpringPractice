package com.jpa.dao.impl;

import com.jpa.dao.StudentDAO;
import com.jpa.model.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student addStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Cacheable(cacheNames = "studentCache")
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }
}
