package com.veysel.controller;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.User;
import com.veysel.service.MyFactoryService;
import com.veysel.service.UserService;
import com.veysel.util.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserController  {

    UserService userService;
    EntityManager entityManager;

    public UserController() {
        this.userService=new UserService();

    }

    public User save(User user){
       return userService.save(user);
   }

    public List<User> saveAll(List<User> userList){
        return (List<User>) userService.saveAll(userList);

    }


    public Optional<User> findByTcKimlik(String tc) {
        return userService.findByTcKimlik(tc);
    }
}
