package com.jpa.worker;

import com.jpa.dao.TeacherDAO;
import com.jpa.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("teacherWorker")
@Transactional
public class TeacherWorker {

    @Autowired
    TeacherDAO teachersDao;

    public Teacher addTeacher(Teacher teacher) {
        teacher = teachersDao.addTeacher(teacher);
        return teacher;
    }

    public Teacher getTeacher(Integer id) {
        return teachersDao.getTeacher(id);
    }

}
