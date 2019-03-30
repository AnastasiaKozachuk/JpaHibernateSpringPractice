package com.jpa;

import com.jpa.model.Student;
import com.jpa.model.Teacher;
import com.jpa.worker.StudentWorker;
import com.jpa.worker.TeacherWorker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);

        StudentWorker studentWorker = context.getBean(StudentWorker.class, "studentWorker");
        Student student = studentWorker.getStudent(2);
        System.out.println(student);

        student = studentWorker.getStudent(2);
        System.out.println(student);

        TeacherWorker teacherWorker = context.getBean(TeacherWorker.class, "teacherWorker");
        Teacher teacher = teacherWorker.getTeacher(2);
        System.out.println(teacher);

        teacher = teacherWorker.getTeacher(2);
        System.out.println(teacher);

        context.close();

    }

}
