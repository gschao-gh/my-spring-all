package com.spr.upload.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spr.upload.struts.model.MessageStore;

/**
 * Created by Administrator on 2016/11/29.
 * Struts执行Action类
 */
public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;

    /**
     * 重写execute方法
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        messageStore = new MessageStore();
        return SUCCESS;
    }


    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }
}
