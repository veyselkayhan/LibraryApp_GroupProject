package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.UserRepository;
import com.veysel.repository.entity.User;


public class UserService  {

    UserRepository userRepository;

    public UserService() {
        this.userRepository=new UserRepository();
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
