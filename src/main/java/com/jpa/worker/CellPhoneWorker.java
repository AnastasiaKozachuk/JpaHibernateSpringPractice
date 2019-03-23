package com.jpa.worker;


import com.jpa.dao.CellPhoneDAO;
import com.jpa.model.CellPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cellPhoneWorker")
@Transactional
public class CellPhoneWorker {


    @Autowired
    CellPhoneDAO cellPhoneDAO;

    public CellPhone addCellPhone(CellPhone group) {
        group = cellPhoneDAO.addCellPhone(group);
        return group;
    }

    public CellPhone getCellPhone(Integer id) {
        return cellPhoneDAO.getCellPhone(id);
    }

}
