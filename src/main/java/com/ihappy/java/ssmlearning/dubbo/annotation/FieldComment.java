package com.ihappy.java.ssmlearning.dubbo.annotation;

import org.codehaus.jackson.annotate.JsonSubTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 域注解
 *@Target(ElementType.FIELD)目标：元素类型域
 * @Retention(RetentionPolicy.RUNTIME)保留：保留政策：运行
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldComment {
    //String 值 默认 空字符串
    String value() default "";
    //请求默认false
    boolean required() default false;
    //字符串 默认值 默认空字符串
    String defaultValue() default "";
}
