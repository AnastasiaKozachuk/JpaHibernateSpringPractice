package com.jpa;

import com.jpa.model.Group;
import com.jpa.model.Lecture;
import com.jpa.model.Schedule;
import com.jpa.model.Teacher;
import com.jpa.worker.GroupWorker;
import com.jpa.worker.LecturesWorker;
import com.jpa.worker.ScheduleWorker;
import com.jpa.worker.TeacherWorker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);

   /*     Lecture lecture = new Lecture();
        lecture.setLectureName("Introduction to Spring");
        lecture.setCredits(2.5);

*/



   /*     CellPhone cellPhone = new CellPhone();
        cellPhone.setCellPhone("09827832382");*/


/*
        CellPhoneWorker cellPhoneWorker = context.getBean(CellPhoneWorker.class,"cellPhoneWorker");
        cellPhoneWorker.addCellPhone(cellPhone);
*/

/*        Teacher teacher = new Teacher();

        teacher.setFirstName("Viktor");
        teacher.setLastName("Remen");
        teacher.setBirthDate(LocalDate.now());
        teacher.setCellPhone(cellPhone);*/

 /*       Group group = new Group();
        group.setCourse(3);
        group.setFaculty("Informatics");
        group.setKafedra("Merezni systemi");
        group.setSpecializationName("Computer science");
*/
       /*

        Address address = new Address();
        address.setCity("Kiev");
        address.setCountry("Ukraine");
        address.setHouseNum("13");
        address.setStreet("Volynska");
        address.setZipcode("23422");

        Student student = new Student();
        student.setAddress(address);
        student.setGroup(group);
        student.setPib("Kalinovska Julia");

        StudentWorker studentWorker = context.getBean(StudentWorker.class, "studentWorker");
        studentWorker.addStudent(student);
        context.close();*/

        GroupWorker groupWorker = context.getBean(GroupWorker.class, "groupWorker");
        Group group = groupWorker.getGroup(1);

        LecturesWorker worker = context.getBean(LecturesWorker.class, "worker");
        Lecture lecture = worker.getLecture(1);

        TeacherWorker teacherWorker = context.getBean(TeacherWorker.class, "teacherWorker");
        Teacher teacher = teacherWorker.getTeacher(2);

        Schedule schedule = new Schedule();
        schedule.setClassNum(234);
        schedule.setDayOfTheWeek("Monday");
        schedule.setLecturerNum(1);
        schedule.setLecture(lecture);
        schedule.setGroupList(Arrays.asList(group));
        schedule.setTeacher(teacher);

        ScheduleWorker scheduleWorker = context.getBean(ScheduleWorker.class, "scheduleWorker");
        scheduleWorker.addSchedule(schedule);
    }

}
