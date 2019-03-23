package com.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "university_groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "course", nullable = false)
    private Integer course;

    @Column(name = "faculty", nullable = false, columnDefinition = "varchar(30)")
    private String faculty;

    @Transient
    private String kafedra;

    @Column(name = "specialization_name", nullable = false, columnDefinition = "varchar(40)")
    private String specializationName;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @ManyToMany
    @JoinTable(
            name = "schedule_for_group",
            joinColumns = @JoinColumn(name = "group_fk"),
            inverseJoinColumns = @JoinColumn(name = "schedule_fk")
    )
    private List<Schedule> schedules;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public String getKafedra() {
        return kafedra;
    }

    public void setKafedra(String kafedra) {
        this.kafedra = kafedra;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
