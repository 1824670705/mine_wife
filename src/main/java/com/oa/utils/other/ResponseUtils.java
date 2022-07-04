package com.oa.utils.other;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {

    /**
     * 响应数据给客户端
     *
     * @param response 响应
     * @param obj      内容
     * @throws IOException IO异常
     */
    public static void responseInfoByJson(HttpServletResponse response, Object obj) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        // 设置响应的数据
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(obj));
        writer.flush();
        writer.close();
    }
}
