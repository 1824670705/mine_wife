package com.oa.domain.security.token;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import org.springframework.security.authentication.AccountExpiredException;

import java.util.Calendar;
import java.util.Date;

public class TokenUtils {

    // 毫秒   24h
    private static final int tokenExpireDate = 24 * 60 * 60 * 1000;
    // 编码密钥
    private static final String tokenSignKey = "ApplicationName=MineOfWife&AuthInfo=XingMr's";

    /**
     * 创建新的 token
     */
    public static String createToken(OaUserLoginResponseVo userLoginResponseVo) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, tokenExpireDate);
        return JWT.create()
                .withClaim("loginInfo", JSONObject.parseObject(JSON.toJSONString(userLoginResponseVo)))
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(tokenSignKey.getBytes()));
    }

    /**
     * 解析 token
     */
    public static OaUserLoginResponseVo parseToken(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(tokenSignKey.getBytes())).build().verify(token);
        Date expiresAt = verify.getExpiresAt();
        if (expiresAt.getTime() < System.currentTimeMillis()) {
            throw new AccountExpiredException("登录过期");
        }
        Claim loginInfo = verify.getClaim("loginInfo");
        return loginInfo.as(OaUserLoginResponseVo.class);
    }
}
