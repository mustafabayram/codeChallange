package com.obilet.android.kariyernetchallange.domain.entity;

/**
 * Created by Mustafa Bayram on 2019-09-22.
 */
public class User {
    public String userName;
    public String password;
    public boolean rememberMe;

    public User(String userName, String password, boolean rememberMe) {
        this.userName = userName;
        this.password = password;
        this.rememberMe = rememberMe;
    }
}
