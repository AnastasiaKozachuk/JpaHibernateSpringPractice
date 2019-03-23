package com.jpa.dao;

import com.jpa.model.Teacher;

public interface TeacherDAO {

    Teacher addTeacher(Teacher teacher);

    Teacher getTeacher(int id);


}
