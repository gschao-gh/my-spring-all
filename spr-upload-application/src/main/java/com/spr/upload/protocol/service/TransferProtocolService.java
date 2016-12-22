package com.spr.upload.protocol.service;

import com.spr.upload.protocol.module.ExecuteResult;
import com.spr.upload.protocol.reportutil.MyResourceUtil;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import java.io.*;
import java.util.HashMap;

/**
 * 债权转让协议
 * @author gschao
 * @date 2016/12/22 16:11.
 */
public class TransferProtocolService implements IProtocolTemplateService {

    public void init() {

    }

    public ExecuteResult create() {
        InputStream in = null;
        OutputStream out = null;
        HashMap<String,Object> paraMap = new HashMap<>();
        paraMap.put("agreementid","A2016122298");
        paraMap.put("transfername","张三");
        paraMap.put("transferaccount","123456789");
        paraMap.put("transferidcode","410423198623456789");
        paraMap.put("assigneename","李四");
        paraMap.put("assigneeaccount","3456789");
        paraMap.put("assigneeidcode","410456198723456788");
        paraMap.put("loanagreementnum","L23456");
        paraMap.put("principal","12345.9");
        paraMap.put("transferamount","6700.00");
        paraMap.put("transferfee","50.00");
        paraMap.put("receivamount","6788.00");
        paraMap.put("signdate","2016年12月22日");


        File jasperFile = null;
        try {
          jasperFile = MyResourceUtil.getFile("classpath:transferofclaimsAgreement_stable.jasper");
            in = new FileInputStream(jasperFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            File outFile =  new File(jasperFile.getPath().substring(0,jasperFile.getPath().lastIndexOf("\\"))+"\\transfer"+(Math.round(Math.random()*1000))+".pdf");
            File htmlFile =  new File(jasperFile.getPath().substring(0,jasperFile.getPath().lastIndexOf("\\"))+"\\transfer"+(Math.round(Math.random()*1000))+".html");
            if(!outFile.exists()){
                try {
                    outFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            out = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            JasperRunManager.runReportToPdfStream(in,out,paraMap,new JREmptyDataSource());

//            JasperRunManager.runReportToHtmlFile(jasperFile.getPath(),)
        } catch (JRException e) {
            e.printStackTrace();
        }

        return null;
    }
}
