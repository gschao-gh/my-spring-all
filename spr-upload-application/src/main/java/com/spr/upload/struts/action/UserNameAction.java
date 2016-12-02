package com.spr.upload.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spr.upload.struts.model.MessageStore;

/**
 * @author gschao
 * @date 2016/11/30 11:21.
 */
public class UserNameAction extends ActionSupport {

    private String userName;
    private MessageStore messageStore;

    @Override
    public String execute() throws Exception {
        messageStore = new MessageStore();
       if(userName!=null){
           messageStore.setMessage(messageStore.getMessage()+" "+userName);
       }
       return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
