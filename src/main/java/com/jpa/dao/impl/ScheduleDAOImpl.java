package com.jpa.dao.impl;

import com.jpa.dao.ScheduleDAO;
import com.jpa.model.Schedule;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ScheduleDAOImpl implements ScheduleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Schedule addSchedule(Schedule schedule) {
        entityManager.persist(schedule);
        return schedule;
    }

    @Override
    public Schedule getSchedule(int id) {
        return entityManager.find(Schedule.class, id);
    }
}
