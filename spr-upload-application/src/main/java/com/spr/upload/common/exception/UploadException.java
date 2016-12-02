package com.spr.upload.common.exception;

/**
 * @author gschao
 * @date 2016/12/2 15:55.
 * @describe 上传异常码定义
 */
public enum UploadException {

    AUTHOR_EXCEPTION("FS001","无权限上传"),
    ZIP_EXCEPTION("FS002","编码失败"),
    PARAUPLOAD_EXCEPTION("FS003","参数异常"),
    OPERATION_EXCEPTION("FS004","操作失败");

    private UploadException(String errorCode,String errorMesg){
        this.errorMesg = errorMesg;
        this.errorCode = errorCode;
    }

    private String errorMesg;
    private String errorCode;

}
