package com.spr.upload.base;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private Logger logger = LogManager.getLogger(BaseAction.class);
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext servletContext;
    private  String savePath;



    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletContext(ServletContext context) {
        this.servletContext = context;
    }

    /**
     * @date 2016-12-03
     * @author gschao
     * 获得图片本地存储路径
     * @return
     */
    public String getSavePath() {
        if(null==savePath||savePath.length()==0){
            savePath = BaseAction.class.getResource("").getPath();
            logger.info("getSavePath:"+savePath);
            savePath = savePath.substring(0,savePath.lastIndexOf("WEB-INF"));
            logger.info("savePath:"+savePath);
        }
        return savePath;
    }


    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
