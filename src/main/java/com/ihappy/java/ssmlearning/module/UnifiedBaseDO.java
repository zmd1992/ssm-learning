package com.ihappy.java.ssmlearning.module;


import com.ihappy.java.ssmlearning.common.util.UnifiedLogThreadLocal;
import com.ihappy.java.ssmlearning.common.util.UnifiedLogUtil;
import com.ihappy.java.ssmlearning.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * 统一基本Data Out [output] 数据输出
 * DO :与数据库表结构一一对应，通过DAO层向上传输数据源对象。
 */
public class UnifiedBaseDO implements Serializable {
    @FieldComment(value = "请求统一id")
    private String requestUnifiedId;
    @FieldComment(value = "客户端IP")
    private String clientIp;

    public UnifiedBaseDO() {
    }

    public String getRequestUnifiedId() {
        return requestUnifiedId;
    }

    public void setRequestUnifiedId(String requestUnifiedId) {
        this.requestUnifiedId = requestUnifiedId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * 进入统一日志
     */
    public void enterUnifiedLog() {
        //得到请求统一id
        this.requestUnifiedId = UnifiedLogThreadLocal.getRequestId();
        //客户端IP等于统一日志里的主机IP
        this.clientIp = UnifiedLogUtil.getHostIp();
    }
}
