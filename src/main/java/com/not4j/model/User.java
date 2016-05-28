package com.not4j.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.not4j.json.views.UserView;

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
    @JsonView(UserView.Public.class)
    private Long userId;
    @JsonView(UserView.Public.class)
    private String login;
    @JsonView(UserView.Internal.class)
    private String password;
    @JsonView(UserView.Public.class)
    private String name;
    @JsonView(UserView.Public.class)
    private Integer age;

    public User() {
    }

    public User(String login, String password, String name, Integer age) {
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
