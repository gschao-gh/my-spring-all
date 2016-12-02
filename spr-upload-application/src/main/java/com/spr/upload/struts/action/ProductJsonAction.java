package com.spr.upload.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.spr.upload.struts.model.MyJsonBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;

import java.util.Arrays;

/**
 * @author gschao
 * @date 2016/12/2 14:17.
 * 产品jsonAction
 */
public class ProductJsonAction extends ActionSupport {
    private Logger logger = LogManager.getLogger(ProductJsonAction.class);

    private MyJsonBean bean;

    @Override
    public String execute() throws Exception {
        bean = new MyJsonBean(2, Arrays.asList("ZhangMing","LiXiaoRan"));
        logger.info("bean:"+bean.getNames());
        return SUCCESS;
    }

    public MyJsonBean getBean() {
        return bean;
    }

    public void setBean(MyJsonBean bean) {
        this.bean = bean;
    }
}
