package com.aimax.kyoiku.bean;

import java.io.Serializable;

public class BoadBean implements Serializable {

	private String name = "";
	private String sessionId = "";
    private String write = "";
    private String date = "";

    public String getName() {
        return name;
    }

    public String getSessionId() {
    	return sessionId;
    }

    public String getWrite() {
    	return write;
    }

    public String getDate() {
    	return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSessionId(String sessionId) {
    	this.sessionId = sessionId;
    }

    public void setWrite(String write) {
    	this.write = write;
    }

    public void setDate(String date) {
    	this.date = date;
    }

}