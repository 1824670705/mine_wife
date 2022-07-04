package com.oa.domain.security.token;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.oa.domain.security.handler.LoginUserDetails;

import java.util.Calendar;

public class TokenUtils {

    // 毫秒   24h
    private static final int tokenExpireDate = 24 * 60 * 60 * 1000;
    // 编码密钥
    private static final String tokenSignKey = "ApplicationName=MineOfWife&AuthInfo=XingMr's";

    /**
     * 创建新的 token
     */
    public static String createToken(LoginUserDetails loginUserDetails) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, tokenExpireDate);
        return JWT.create()
                .withClaim("loginInfo", JSONObject.parseObject(JSON.toJSONString(loginUserDetails)))
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(tokenSignKey.getBytes()));
    }

    /**
     * 解析 token
     */
    public static LoginUserDetails parseToken(String token) {
        return null;
    }
}
