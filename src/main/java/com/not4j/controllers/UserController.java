package com.not4j.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.not4j.dao.UserDao;
import com.not4j.json.views.UserView;
import com.not4j.model.Trip;
import com.not4j.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @JsonView(UserView.Public.class)
    public Collection<User> getAllUsers() {
        return userDao.findAll();
    }

    @RequestMapping(value = "/{userId}/trip", method = RequestMethod.GET)
    public Collection<Trip> getAllTripsByUser(@PathVariable Long userId) {
        return userDao.findOne(userId).getTrips();
    }
}
