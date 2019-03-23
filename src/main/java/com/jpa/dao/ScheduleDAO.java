package com.jpa.dao;

import com.jpa.model.Schedule;

public interface ScheduleDAO {

    Schedule addSchedule(Schedule schedule);

    Schedule getSchedule(int id);

}
