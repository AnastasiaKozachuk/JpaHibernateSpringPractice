package com.jpa.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "cellphone")
public class CellPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cell_phone_id")
    private Integer cellPhoneId;

    @Column(name = "cell_phone", nullable = false, columnDefinition = "varchar(15)")
    private String cellPhone;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "teacher_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Teacher teacher;

    public Integer getCellPhoneId() {
        return cellPhoneId;
    }

    public void setCellPhoneId(Integer cellPhoneId) {
        this.cellPhoneId = cellPhoneId;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
