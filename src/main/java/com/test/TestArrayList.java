package com.test;

import com.domain.User;

import java.util.ArrayList;

public class TestArrayList<User> extends ArrayList {

    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
