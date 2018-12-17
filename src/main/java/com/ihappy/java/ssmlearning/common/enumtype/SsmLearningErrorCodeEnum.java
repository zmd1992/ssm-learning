package com.ihappy.java.ssmlearning.common.enumtype;


public enum SsmLearningErrorCodeEnum {
    PASSWORD_IS_NOT_NULL("password_is_not_null", "密码不能为空"),
    USER_NAME_IS_NOT_NULL("USER_NAME_IS_NOT_NULL", "用户名不能为空"),
    USER_NAME_IS_REPEAT("USER_NAME_IS_REPEAT", "用户名重复"),
    ;
    /**
     * 错误信息
     */
    private String errMsg;
    /**
     * 错误码
     */
    private String errCode;

    //将getter和setter放在方法之后


    SsmLearningErrorCodeEnum(String errMsg, String errCode) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    /**
     * 新建一个返回对象是这个枚举的static方法
     *
     * @param code
     * @return
     */
    public static SsmLearningErrorCodeEnum getTbcpErrorCodeEnum(String code) {
        /**
         * 循环枚举的值
         */
        for (SsmLearningErrorCodeEnum ssmLearningErrorCodeEnum : SsmLearningErrorCodeEnum.values()) {
            /**
             * 如果枚举的错误码等于code，返回枚举对象，否则返回null
             */
            if (ssmLearningErrorCodeEnum.getErrCode().endsWith(code)) {
                return ssmLearningErrorCodeEnum;
            }
        }
        return null;
    }

    SsmLearningErrorCodeEnum(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
