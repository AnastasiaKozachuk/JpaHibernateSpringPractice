package com.jpa.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer id;

    @Column(name = "day_of_the_week", nullable = false, columnDefinition = "varchar(20)")
    private String dayOfTheWeek;

    @Column(name = "lecturer_num", nullable = false)
    private Integer lecturerNum;

    @Column(name = "class_num", nullable = false)
    private Integer classNum;

    @ManyToOne
    @JoinColumn(name = "lecture_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "teacher_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name = "schedule_for_group",
            joinColumns = @JoinColumn(name = "schedule_fk"),
            inverseJoinColumns = @JoinColumn(name = "group_fk")
    )
    private List<Group> groupList;


    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Integer getLecturerNum() {
        return lecturerNum;
    }

    public void setLecturerNum(Integer lecturerNum) {
        this.lecturerNum = lecturerNum;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }
}
