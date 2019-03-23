package com.jpa.dao;

import com.jpa.model.Student;

public interface StudentDAO {

    Student addStudent(Student student);

    Student getStudent(int id);

}
