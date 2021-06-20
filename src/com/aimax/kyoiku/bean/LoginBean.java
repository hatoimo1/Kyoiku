package com.aimax.kyoiku.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private String userId = "";
    private String name = "";
    private String text = "";
    private String password = "";

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getText() {
    	return text;
    }

    public String getPassword() {
    	return password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
    	this.text = text;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

}