package com.testweb.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/15.
 */
public class LoginLog implements Serializable {
    private int LoginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public int getLoginLogId() {
        return LoginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        LoginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "LoginLogId=" + LoginLogId +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", loginDate=" + loginDate +
                '}';
    }
}
