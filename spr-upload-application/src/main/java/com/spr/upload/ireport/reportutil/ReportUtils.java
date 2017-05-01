package com.spr.upload.ireport.reportutil;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

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


    /**
     * 将Object转换为数据源，支持list和Map数据源
     * @gschao
     * @date 2016-12-24
     * @param obj 支持Collection实现类
     * @return
     */
    public static JRDataSource getDateSource(Object obj){
        List<Map<String,?>> listSource = new ArrayList<>();
        Map<String,JRDataSource> dataSourceMap = new HashMap<>();
        if(obj instanceof Map){
            Map<String,Object> objectMap = (Map<String, Object>) obj;
            Set<Map.Entry<String,Object>> mapset = objectMap.entrySet();
            for (Map.Entry<String,Object> entry:mapset) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if(value instanceof List){
                    List<Map<String,?>> list = (List<Map<String, ?>>) value;
                    JRMapCollectionDataSource jcd = new JRMapCollectionDataSource(list);
                    dataSourceMap.put(key,jcd);
                }
            }
            listSource.add(dataSourceMap);
        }else if(obj instanceof List){
            listSource = (List<Map<String, ?>>) obj;
        }
        JRMapCollectionDataSource rtjd = new JRMapCollectionDataSource(listSource);
        return rtjd;
    }

    /**
     * 生成Pdf文件
     * @author gschao
     * @date 2016-12-24
     * @param jasperFilePath
     * @param destFilePath
     * @param paraMap
     * @return
     */
    public static String createPdfReport(String jasperFilePath,String destFilePath,HashMap<String,Object> paraMap) throws Exception {
        Map<String, List> mapSource = new HashMap<>();

        for (Map.Entry<String,Object> tmp:paraMap.entrySet()) {
            String key = tmp.getKey();
            Object obj = tmp.getValue();
//            参数为Map
            if (obj instanceof Map){
                HashMap<String,?> hobj = (HashMap<String, ?>) obj;
                for (Map.Entry<String,?> tmpObj:hobj.entrySet() ) {
                    String tmpKey = tmpObj.getKey();
                    List tmpValue = (List) tmpObj.getValue();
                    mapSource.put(tmpKey,tmpValue);
                }
            }else if(obj instanceof List){
                mapSource.put(key, (List) obj);
            }

        }
        File sourceFile = new File(jasperFilePath);
        if(!sourceFile.exists()){
            throw new Exception("file not exist");
        }
        FileInputStream in = new FileInputStream(sourceFile);
        File destFile  = new File(destFilePath);
        if(!destFile.exists()){
            destFile.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(destFile);
        JRDataSource jRDataSource = getDateSource(mapSource);
        JasperRunManager.runReportToPdfStream(in,out,paraMap,jRDataSource);
        return destFilePath;
    }


}
