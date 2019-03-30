package com.jpa;

import com.jpa.model.Student;
import com.jpa.model.Teacher;
import com.jpa.worker.StudentWorker;
import com.jpa.worker.TeacherWorker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);

        System.out.println("\nCache example: \n");

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

        System.out.println("\nDynamic query: \n");

        for (Student student1 : studentWorker.findAllDynamicQuery()) {
            System.out.println(student1);
        }

        System.out.println("\nCriteria API query: \n");

        for (Student student1 : studentWorker.findAllCriteriaApi()) {
            System.out.println(student1);
        }

        System.out.println("\nNamed query: \n");

        for (Student student1 : studentWorker.findAllNamedQuery()) {
            System.out.println(student1);
        }

        System.out.println("\nNative query: \n");

        for (Student student1 : studentWorker.findAllNativeQuery()) {
            System.out.println(student1);
        }



        context.close();

    }

}
