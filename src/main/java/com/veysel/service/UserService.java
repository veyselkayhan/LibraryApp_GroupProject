package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.User;


public class UserService extends MyFactoryService<User, ID> {
    public UserService() {
        super(new User());
    }
}
