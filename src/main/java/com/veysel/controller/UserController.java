package com.veysel.controller;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.User;
import com.veysel.service.MyFactoryService;
import com.veysel.service.UserService;

public class UserController  {

    UserService userService;

    public UserController() {
        this.userService=new UserService();
    }

    public User save(User user){
       return userService.save(user);
   }

}
