package com.spr.upload.protocol.reportutil;



import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author gschao
 * @date 2016/12/21 14:29.
 * 资源加载工具类
 */
public class MyResourceUtil {
    Logger logger = LogManager.getLogger(MyResourceUtil.class);
    /**
     * 根据文件名称重配置目录加载文件
     * @param resourceLocation 文件名称
     * @return
     */
    public static File getFile(String resourceLocation) throws FileNotFoundException {
        if (resourceLocation==null||resourceLocation.length()==0){

        }
        if(resourceLocation.startsWith("classpath:")){
            String ex = resourceLocation.substring("classpath:".length());
            ClassLoader cl = ClassUtils.getDefaultClassLoad();
            URL url = cl != null?cl.getResource(ex):ClassLoader.getSystemResource(ex);
            if(url==null){
                String description = "class path resource [" + ex + "]";
                throw new FileNotFoundException(description + " cannot be resolved to URL because it does not exist");
            }else{
                return getFile(url);
            }

        }else{
            try {
                return getFile(new URL(resourceLocation));
            } catch (MalformedURLException e) {
                return new File(resourceLocation);
            }
        }

    }

    /**
     * 根据字符串地址生成URI
     * @author gschao
     * @date 2016-12-22
     * @param location 字符串地址
     * @return
     * @throws URISyntaxException
     */
    public static URI toURI(String location) throws URISyntaxException {
        return new URI(StringUtils.replace(location," ","%20"));
    }

    /**
     * @author gschao
     * 根据URL获取资源文件对象
     * @param resourceURl 资源地址URL对象
     * @return
     * @throws FileNotFoundException
     * @date 2016-12-22
     */
    public static File getFile(URL resourceURl) throws FileNotFoundException {
        if(resourceURl==null){
            String description = "class path resource ["+resourceURl+"]";
            throw new FileNotFoundException(description + " cannot be resolved to URL because it does not exist");
        }else if(!"file".equals(resourceURl.getProtocol())){
            throw new FileNotFoundException(" because it does not reside in the file system:"+resourceURl);
        }else{
            try {
                return new File(toURI(resourceURl.toString()).getSchemeSpecificPart());
            } catch (URISyntaxException e) {
                return new File(resourceURl.getFile());
            }
        }
    }


}
