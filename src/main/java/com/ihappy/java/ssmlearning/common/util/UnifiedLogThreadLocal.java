package com.ihappy.java.ssmlearning.common.util;

import com.ihappy.java.ssmlearning.common.enumtype.ReuquestTypeEnum;
import com.konglong.dubbo.annotation.FieldComment;
import org.omg.CORBA.TRANSACTION_MODE;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一日志本地线程
 */
public class UnifiedLogThreadLocal {
    @FieldComment(value = "客户端IP")
    private static final String CLIENT_IP = "clientIp";
    @FieldComment(value = "请求id")
    private static final String REQUEST_ID = "requestId";
    @FieldComment(value = "请求类型")
    private static final String REQUEST_TYPE = "requestType";
    @FieldComment(value = "本地线程")
    static final ThreadLocal<Map<String, Object>> local = new ThreadLocal();

    public UnifiedLogThreadLocal() {
    }

    //获取客户端IP
    public static String getClientIp() {
        //如果本地线程得到的为空,设置客户端IP为空
        if (local.get() == null) {
            setClientIp("");
        }
        return (String) local.get().get("clientIp");
    }

    //设置客户端IP
    private static void setClientIp(String clientIp) {
        //建本地线程的一个Map集合
        Map<String, Object> map = local.get();
        //如果集合为空，返回new HashMap()
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("clientIp", clientIp);
        local.set(map);
    }

    //设置请求id
    public static void setRequestId(String requestId) {
        //如果请求IPn不为空字符串
        if (!StringUtil.isBlank(requestId)) {
            //新建本地线程集合
            Map<String, Object> map = local.get();
            //如果map为null，返回new HashMap
            if (map == null) {
                map = new HashMap<>();
            }
            //将请求id放入map中
            map.put("requestId", requestId);
            //本地设置map
            local.set(map);
        }
    }

    //得到请求id
    public static String getRequestId() {
        //如果本地线程获取的是null或本地线程获取的获取的请求id为null，设置请求id
        if (local.get() == null || local.get().get("requestId") == null) {
            setRequestId(UUIDUtil.getUUID(true));
        }
        return (String) local.get().get("requestId");
    }

    //设置请求类型
    public static void setRequestType(String requestType) {
        //新建本地线程map集合
        Map<String, Object> map = local.get();
        //如果map等于null，返回new HashMap
        if (map == null) {
            map = new HashMap<>();
        }
        //将请求类型放入map集合
        map.put("requestType", requestType);
        //本地线程这是map集合
        local.set(map);
    }

    //得到请求类型
    public static String getRequestType() {
        //如果本地线程得到的是null或本地线程得到的得到的请求类型是null，设置请求类型为随机生成的UUID
        if (local.get() == null || local.get().get("requestType") == null) {
            setRequestType(UUIDUtil.getUUID(true));
        }
        //否则返回本地得到请求类型
        return (String) local.get().get("requestType");
    }

    /**
     * 移除
     */
    public static void remove() {
        //如果本地线程不为null或得到的请求类型等于
        //http，设置本地线程为null，移除本地线程
        if (local != null && !getRequestType().equals(ReuquestTypeEnum.HTTP.getType())) {
            local.set(null);
            local.remove();
        }
    }
}
