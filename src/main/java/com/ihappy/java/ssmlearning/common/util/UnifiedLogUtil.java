package com.ihappy.java.ssmlearning.common.util;

import com.ihappy.java.ssmlearning.dubbo.annotation.FieldComment;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 统一日志工具
 */
public class UnifiedLogUtil {
    @FieldComment(value = "主机IP")
    private static String hostIp = "";

    public UnifiedLogUtil() {
    }

    //得到主机IP
    public static String getHostIp() {
        //如果主机IP不等于null，返回主机IP
        if (StringUtil.isNotBlank(hostIp)) {
            return hostIp;
        } else {
            //否则得到本地地址IP,返回主机IP
            hostIp = getLocalAddressIp();
            return hostIp;
        }
    }

    /**
     * 得到本地地址IP
     *
     * @return
     */
    private static String getLocalAddressIp() {
        //初始化本地址IP为空字符串
        String localHostIp = "";
        try {
            //枚举值得到网络接口
            Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
            //循环枚举
            while (enumeration.hasMoreElements()) {
                //得到下一个元素
                NetworkInterface inf = (NetworkInterface) enumeration.nextElement();
                //得到intent地址
                Enumeration enumIpAddr = inf.getInetAddresses();
                //循环intent地址
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumeration.nextElement();
                    //如果因特网地址不是循环的且不是连接本地的地址且不是网站的本地地址，本地主机IP等于因特网得到主机地址转换成字符串
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        localHostIp = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return localHostIp;
    }
}
