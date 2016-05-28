package com.not4j.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.not4j.dao.UserDao;
import com.not4j.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author: ivan
 * Date: 28.05.16
 * Time: 20:12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    Collection<User> getAllUsers() {
        return userDao.findAll();
    }
}
