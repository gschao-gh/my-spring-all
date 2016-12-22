package com.spr.upload.protocol.reportutil;

import net.sf.jasperreports.engine.JasperCompileManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * @author gschao
 * @date 2016/12/22 11:26.
 * 报表工具类
 */
public class ReportUtils {
    private static Logger logger = LogManager.getLogger(ReportUtils.class);

    public void ReportUtils(){

    }

    /**
     * 报表jrxml编译生成jasper文件
     * @param jrxmlFileName
     * @return
     * @throws Exception
     */
    public static String convertJrxmltoJasper(String jrxmlFileName) throws Exception {
        String jasperFilePath = "";
        try{
            File file = MyResourceUtil.getFile(jrxmlFileName);
            String jrxmlPath = file.getPath();
            String saveDir = jrxmlPath.substring(0,jrxmlPath.lastIndexOf("\\"));
            String jasperName = jrxmlFileName.substring(0,jrxmlFileName.lastIndexOf("."));
            jasperFilePath = saveDir+"\\"+jasperName.substring(jasperName.lastIndexOf(":")+1)+".jasper";
            JasperCompileManager.compileReportToFile(jrxmlPath,jasperFilePath);

        }catch (Exception e){
            logger.error("报表模板编译异常",e);
        }

        return jasperFilePath;

    }

}
