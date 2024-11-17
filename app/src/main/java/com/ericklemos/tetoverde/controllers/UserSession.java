package com.ericklemos.tetoverde.controllers;

public class UserSession {
    private static UserSession instance;
    private int userId = 2;

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
}
