package com.spr.upload.ireport.service;

import com.spr.upload.ireport.module.ExecuteResult;

/**
 * @author gschao
 * @version
 * @return
 * @since
 * @date 2016/12/21 11:46.
 */
public interface IProtocolTemplateService {
    /**
     * 初始化报表
     * @author gschao
     * @date 2016/12/21 11:46.
     */
    public void init();

    /**
     * 生成报表,返回执行结果
     * @return
     */
    public ExecuteResult create();


}
