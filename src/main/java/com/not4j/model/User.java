package com.not4j.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: ivan
 * Date: 28.05.16
 * Time: 19:01
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String login;
    private String name;
    private Integer age;

    public User() {
    }

    public User(String login, String name, Integer age) {
        this.login = login;
        this.name = name;
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
