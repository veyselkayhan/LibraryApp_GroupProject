package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.UserRepository;
import com.veysel.repository.entity.User;

import java.util.List;
import java.util.Optional;


public class UserService extends MyFactoryService<User,Long> {

    UserRepository userRepository;
    public UserService() {
        super(new User());
        this.userRepository=new UserRepository();

    }
    public Optional<User> findByTcKimlik(String tc) {
        return userRepository.findByTcKimlik(tc);
    }

    public User userSave() {
        return userRepository.userSave();
    }
}
