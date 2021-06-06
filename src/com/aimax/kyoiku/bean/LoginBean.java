package com.aimax.kyoiku.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private String userId;
    private String name = "";
    private String text = "";

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getText() {
    	return text;
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

}