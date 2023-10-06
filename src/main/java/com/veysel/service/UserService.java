package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.UserRepository;
import com.veysel.repository.entity.User;

import java.util.List;
import java.util.Optional;


public class UserService  {

    UserRepository userRepository;

    public UserService() {
        this.userRepository=new UserRepository();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> saveAll(List<User> userList){
        return (List<User>) userRepository.saveAll(userList);
    }

    public Optional<User> findByTcKimlik(String tc) {
        return userRepository.findByTcKimlik(tc);
    }
}
