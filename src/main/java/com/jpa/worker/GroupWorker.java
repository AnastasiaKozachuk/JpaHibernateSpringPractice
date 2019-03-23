package com.jpa.worker;

import com.jpa.dao.GroupDAO;
import com.jpa.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("groupWorker")
@Transactional
public class GroupWorker {

    @Autowired
    GroupDAO groupDAO;

    public Group addGroup(Group group) {
        group = groupDAO.addGroup(group);
        return group;
    }

    public Group getGroup(Integer id) {
        return groupDAO.getGroup(id);
    }

}
