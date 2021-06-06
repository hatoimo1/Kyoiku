package com.aimax.kyoiku.bean;

import java.io.Serializable;

public class TableDataBean implements Serializable {

	private String userId = "";
    private String kanaMei = "";
    private String kanaSei = "";
    private String accountId = "";

    public String getUserId() {
        return userId;
    }

    public String getKanaMei() {
        return kanaMei;
    }

    public String getKanaSei() {
    	return kanaSei;
    }

    public String getAccountId() {
    	return accountId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setKanaMei(String kanaMei) {
        this.kanaMei = kanaMei;
    }

    public void setKanaSei(String kanaSei) {
    	this.kanaSei = kanaSei;
    }

    public void setAccountId(String accountId) {
    	this.accountId = accountId;
    }

}