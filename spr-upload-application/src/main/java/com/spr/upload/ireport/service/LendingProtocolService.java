package com.spr.upload.ireport.service;

import com.spr.upload.ireport.module.ExecuteResult;
import com.spr.upload.ireport.reportutil.ClassUtils;
import com.spr.upload.ireport.reportutil.MyResourceUtil;
import com.spr.upload.ireport.reportutil.ReportUtils;
import net.sf.jasperreports.engine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 借款协议服务
 * @author gschao
 * @date 2016/12/22 16:10.
 */
public class LendingProtocolService implements IProtocolTemplateService {
    private static Logger logger = LogManager.getLogger(LendingProtocolService.class);
//报表生成主要使用的类
//    编译类主要完成报表从jrxml文件编译生成jasper文件，序列化到磁盘
//    net.sf.jasperreports.engine.JasperCompileManager
//    填充jasper文件填充
//    net.sf.jasperreports.engine.JasperFillManager
//    生成一个待打印的文件
//    net.sf.jasperreports.engine.JasperPrintManager
//    协助导出xls,RTF,ODT,txt的文档
//    net.sf.jasperreports.engine.JasperExportManager


    public void init() {

    }

    public ExecuteResult create() {
        InputStream in = null;
        OutputStream out = null;
        String basePath = ClassUtils.getDefaultClassLoad().getResource("").getPath();
        logger.info("###basePath:"+basePath);
//        编译jrxml
        try {
            JasperReport   jasperReport = JasperCompileManager.compileReport(basePath+"lending_services_agreement_stable3.jrxml");


            String destFileName = basePath+"\\"+"lending_protocol"+Math.round(Math.random()*1000)+".pdf";
            String destHtmlFileName = basePath+"\\"+"lending_protocol"+Math.round(Math.random()*1000)+".html";
            HashMap<String,Object> paraMap = new HashMap<>();
            paraMap.put("agreementNum","L234567890");
            paraMap.put("partyAidCard","410423198723456789");
            paraMap.put("accountNum","15311437065");
            paraMap.put("partyAdate","2016年12月23日");
            paraMap.put("partyBdate","2016年12月23日");
            paraMap.put("productType","1");
            paraMap.put("loanAmount","100000.45");
            paraMap.put("loanRate","10%");
            paraMap.put("loanTimeLimit","365天");
            paraMap.put("earnType","转账");

            ArrayList<HashMap<String,String>> table01 = new ArrayList<>();
            for (int i = 0; i <30 ; i++) {
                HashMap<String,String> tmp = new HashMap<>();
                tmp.put("accountNo","134567889"+i);
                tmp.put("lendingRealName","张"+i+"蓉");
                tmp.put("idCard","410423196723456789"+i);
                tmp.put("lendingAmount",String.valueOf(1000*i));
                tmp.put("useWay","贷款养猪养羊养美女");
                tmp.put("remark","");
                table01.add(tmp);
            }

            paraMap.put("table_01",table01);

            ArrayList<HashMap<String,String>> table02 = new ArrayList<>();
            for (int i = 0; i <5 ; i++) {
                HashMap<String,String> tmp = new HashMap<>();
                tmp.put("accountNo","134567889"+i);
                tmp.put("lendAmount",String.valueOf(1000*i));
                tmp.put("lendTimeLimit","90天");
                tmp.put("earnRate",String.valueOf(2*i)+"%");
                tmp.put("earnType","到期还本金");
                table02.add(tmp);
            }

            paraMap.put("table_02",table02);
            File destFile = new File(destFileName);
            if(!destFile.exists()){
                try {
                    destFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            try {
//                in = new FileInputStream(MyResourceUtil.getFile("classpath:lending_services_agreement_stable3.jasper"));
//                out = new FileOutputStream(destFile);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
            try {
                String sourcePath = MyResourceUtil.getFile("classpath:lending_services_agreement_stable3.jasper").getPath();
                ReportUtils.createPdfReport(sourcePath,destFileName,paraMap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


//            JasperRunManager.runReportToPdfStream(in,out,paraMap,new JREmptyDataSource());

//            try {
//               JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport,paraMap);
//               JasperExportManager.exportReportToPdfFile(jasperPrint, destFileName);
//               JasperExportManager.exportReportToHtmlFile(jasperPrint,destHtmlFileName);
//            } catch (JRException e) {
//                e.printStackTrace();
//            }
        } catch (JRException e) {
            logger.error("编译文件失败",e);
        }
//        JasperFillManager.fillReport();

        return null;
    }
}
