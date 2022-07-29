package com.erdemyilmaz.controller;

import com.erdemyilmaz.model.Userinfo;
import com.erdemyilmaz.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserCont {

    @Autowired
    private UserServices userServices;

    //http://localhost:8080/api/v1/user
    @PostMapping ("/user")
    public Userinfo saveUser(@RequestBody Userinfo userinfo){

      /*  userServices.saveUser(userinfo);*/
        return userServices.saveUser(userinfo);
    }
    //http://localhost:8080/api/v1/users
    @GetMapping("/users")
    public List<Userinfo> getAllUser(){

        List<Userinfo> users = userServices.getAllUsers();
        return users;

    }
}
