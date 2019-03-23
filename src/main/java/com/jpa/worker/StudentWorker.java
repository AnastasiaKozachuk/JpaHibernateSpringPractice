package com.jpa.worker;

import com.jpa.dao.StudentDAO;
import com.jpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("studentWorker")
@Transactional
public class StudentWorker {


    @Autowired
    StudentDAO studentDAO;

    public Student addStudent(Student student) {
        student = studentDAO.addStudent(student);
        return student;
    }

    public Student getStudent(Integer id) {
        return studentDAO.getStudent(id);
    }


}
