package com.ihappy.java.ssmlearning.common.domain;

import com.ihappy.java.ssmlearning.module.UnifiedBaseDO;

/**
 * 常见查询 抽象类
 */

public abstract class CommonQuery extends UnifiedBaseDO {
    public CommonQuery() {
    }
    //抽象方法验证
    public abstract void validation();
}
