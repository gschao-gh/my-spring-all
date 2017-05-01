package com.spr.upload.ireport.reportutil;

/**
 * @author gschao
 * @date 2016/12/21 14:35.
 */
public class ClassUtils {
    public void ClassUtils(){
    };


    /**
     * 获取默认的类加载器
     * @return
     */
    public static ClassLoader getDefaultClassLoad(){
        ClassLoader cl = null;
        try{
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Exception e){

        }
        if(cl==null){
            cl = ClassUtils.class.getClassLoader();
            if(cl==null){
                try{
                  cl=ClassLoader.getSystemClassLoader();
                }catch (Exception e){

                }

            }
        }
        return cl;
    }
}
