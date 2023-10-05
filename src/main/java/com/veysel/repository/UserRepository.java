package com.veysel.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.User;
import com.veysel.util.MyFactoryRepository;

public class UserRepository extends MyFactoryRepository<User, ID> {
    public UserRepository() {
        super(new User());
    }
}
