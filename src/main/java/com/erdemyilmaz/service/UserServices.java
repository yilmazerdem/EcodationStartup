package com.erdemyilmaz.service;

import com.erdemyilmaz.model.Userinfo;
import com.erdemyilmaz.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserServices  {
    @Autowired
    public UserRepo userRepo;

    //save user information
    public Userinfo saveUser(Userinfo userinfo)
    {
        userRepo.save(userinfo);
        return userinfo;
    }

    //list all users
    public List<Userinfo> getAllUsers()
    {
        //List<Userinfo> users = new ArrayList<>();
        List<Userinfo> users = userRepo.findAll();
        return users;
    }
}