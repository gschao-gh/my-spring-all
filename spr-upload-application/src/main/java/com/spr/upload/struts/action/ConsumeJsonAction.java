package com.spr.upload.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spr.upload.struts.model.MyJsonBean;
import org.apache.struts2.interceptor.ServletRequestAware;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gschao
 * @date 2016/12/2 14:20.
 */
public class ConsumeJsonAction extends ActionSupport implements ServletRequestAware{


    private MyJsonBean bean = new MyJsonBean();
    private boolean responseAsJson = true;



    public void setServletRequest(HttpServletRequest request) {
        responseAsJson = request.getHeader("Accept").contains("application/json");
    }

    @Override
    public String execute() throws Exception {
        if(responseAsJson){
            return "JSON";
        }
        return SUCCESS;
    }

    public MyJsonBean getBean() {
        return bean;
    }

    public void setBean(MyJsonBean bean) {
        this.bean = bean;
    }
}

