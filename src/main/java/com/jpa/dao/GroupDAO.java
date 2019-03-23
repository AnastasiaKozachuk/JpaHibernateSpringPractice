package com.jpa.dao;

import com.jpa.model.Group;

public interface GroupDAO {

    Group addGroup(Group group);

    Group getGroup(int id);

}
