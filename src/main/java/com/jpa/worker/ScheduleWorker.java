package com.jpa.worker;


import com.jpa.dao.ScheduleDAO;
import com.jpa.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("scheduleWorker")
@Transactional
public class ScheduleWorker {

    @Autowired
    ScheduleDAO scheduleDAO;

    public Schedule addSchedule(Schedule schedule) {
        schedule = scheduleDAO.addSchedule(schedule);
        return schedule;
    }

    public Schedule getSchedule(Integer id) {
        return scheduleDAO.getSchedule(id);
    }

}
