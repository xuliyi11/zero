package com.domain;

/**
 * Created by chenyuan on 2018-04-15.
 */
public class User {
    Integer id;
    String userName;
    String userAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public User(Integer id, String userName, String userAge) {
        this.id = id;
        this.userName = userName;
        this.userAge = userAge;
    }

    public User() {

    }

}
