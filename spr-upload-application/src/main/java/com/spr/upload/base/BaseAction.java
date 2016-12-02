package com.spr.upload.base;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gschao
 * @date 2016/12/2 15:40.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext servletContext;



    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletContext(ServletContext context) {
        this.servletContext = context;
    }
}
