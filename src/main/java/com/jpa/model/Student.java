package com.jpa.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@SuppressWarnings("JpaQlInspection")
@Entity
@Table(name = "students")
@Cacheable
@NamedQueries({
        @NamedQuery(name = Student.FIND_ALL_BY_NAMED_QUERY, query = "SELECT s from Student s")
})
public class Student {

    public static final String FIND_ALL_BY_NAMED_QUERY = "Student.findAllByNamedQuery";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;


    @Column(name = "pib", nullable = false, columnDefinition = "varchar(50)")
    private String pib;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "group_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Group group;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", pib='" + pib + '\'' +
                ", address=" + address +
                ", group=" + group +
                "}";
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
