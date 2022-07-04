package com.oa.utils.other;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    /**
     * 获取请求客户端的 Ip
     *
     * @param request 请求体
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String headerIP = request.getHeader("x-real-ip");
        if (headerIP == null || "".equals(headerIP) || "null".equals(headerIP)) {
            headerIP = request.getHeader("x - forwarded - for");
        }
        if (headerIP != null && !"".equals(headerIP) && !"null".equals(headerIP)) {
            ip = headerIP;
        }
        return ip;
    }
}
