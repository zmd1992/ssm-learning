package com.ihappy.java.ssmlearning.Exception;

import com.ihappy.java.ssmlearning.common.enumtype.SsmLearningErrorCodeEnum;
import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

public class SsmLearningException extends RuntimeException {

    @FieldComment(value = "错误码")
    private String errorCode;
    @FieldComment(value = "错误信息")
    private String errorMessage;
    @FieldComment(value = "详细错误信息")
    private String detailErrorMessage;

    //将getter和setter放在方法之后

    public SsmLearningException(Throwable cause) {
        super(cause.getMessage());
        this.errorCode=cause.getMessage();
    }

    /**
     * 将枚举放入构造器方法里
     * @param ssmLearningErrorCodeEnum
     */
    public SsmLearningException(SsmLearningErrorCodeEnum ssmLearningErrorCodeEnum) {
        super(ssmLearningErrorCodeEnum.getErrCode());
        this.errorCode=ssmLearningErrorCodeEnum.getErrCode();
        this.errorMessage=ssmLearningErrorCodeEnum.getErrMsg();
    }
    public SsmLearningException(SsmLearningErrorCodeEnum ssmLearningErrorCodeEnum,String detailErrorMessage) {
        super(ssmLearningErrorCodeEnum.getErrCode());
        this.errorCode=ssmLearningErrorCodeEnum.getErrCode();
        this.errorMessage=ssmLearningErrorCodeEnum.getErrMsg();
        this.detailErrorMessage=detailErrorMessage;
    }

    public SsmLearningException(String errCode, String errMsg) {
        this.errorCode=errCode;
        this.errorMessage=errMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetailErrorMessage() {
        return detailErrorMessage;
    }

    public void setDetailErrorMessage(String detailErrorMessage) {
        this.detailErrorMessage = detailErrorMessage;
    }
}
