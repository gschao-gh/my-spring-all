package com.spr.upload.struts.model;

/**
 * Created by Administrator on 2016/11/29.
 * 信息存储对象
 */
public class MessageStore {
    private String message;

    public MessageStore() {
        setMessage("你好世界！");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
