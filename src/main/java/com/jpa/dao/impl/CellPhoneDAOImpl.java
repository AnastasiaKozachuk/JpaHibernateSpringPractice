package com.jpa.dao.impl;

import com.jpa.dao.CellPhoneDAO;
import com.jpa.model.CellPhone;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CellPhoneDAOImpl implements CellPhoneDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CellPhone addCellPhone(CellPhone cellPhone) {
        entityManager.persist(cellPhone);
        return cellPhone;
    }

    @Override
    public CellPhone getCellPhone(int id) {
        return entityManager.find(CellPhone.class, id);
    }
}
