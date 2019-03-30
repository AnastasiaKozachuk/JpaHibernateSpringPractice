package com.jpa.worker;

import com.jpa.dao.TeacherDAO;
import com.jpa.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service("teacherWorker")
public class TeacherWorker {

    @Autowired
    private TeacherDAO teachersDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public Teacher addTeacher(final Teacher teacher) {

        transactionTemplate.execute((TransactionCallback<Void>) transactionStatus -> {
            try{
                teachersDao.addTeacher(teacher);
                System.out.println("Teacher has been added.");
            }catch (RuntimeException e){
                transactionStatus.setRollbackOnly();
                throw e;
            }
            return null;

        });

        return teacher;
    }

    public Teacher getTeacher(Integer id) {
        return this.transactionTemplate.execute( status -> teachersDao.getTeacher(id));
    }

}
