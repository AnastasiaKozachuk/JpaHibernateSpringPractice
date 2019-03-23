package com.jpa.dao;

import com.jpa.model.CellPhone;

public interface CellPhoneDAO {

    CellPhone addCellPhone(CellPhone cellPhone);

    CellPhone getCellPhone(int id);

}
