package com.spr.upload.photo;

import com.spr.upload.base.BaseAction;
import com.spr.upload.common.exception.UploadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

/**
 * @author gschao
 * @date 2016/12/2 15:39.
 */
public class ImageUploadAction extends BaseAction {
    private Logger logger = LogManager.getLogger(ImageUploadAction.class);
//    上传文件名
    private String fileName;
//    上传文件
    private File uploadFile;
//    返回存储路径
    private String storePath;

    public String upload(){
        logger.info(UploadException.AUTHOR_EXCEPTION);
        String savePath = getSavePath()+"/upload";




        return SUCCESS;
    }





    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }
}
