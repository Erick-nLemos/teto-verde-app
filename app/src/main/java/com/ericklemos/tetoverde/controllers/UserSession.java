package com.ericklemos.tetoverde.controllers;

public class UserSession {
    private static UserSession instance;
    private int userId;
    private String userName;
    private String token;

    private UserSession(){}

    public static UserSession getInstance(){
        if(instance == null){
            instance = new UserSession();
        }
        return instance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
