package com.oa.domain.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Aspect
@Component
public class LogAop {
    @Pointcut("execution(* com.oa.application.*.controller.*.*(..))")
    public void pointCut() {
    }

    @AfterReturning(value = "pointCut()")
    public void returnAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Class<?> aClass = joinPoint.getTarget().getClass();
        RequestMapping annotation = aClass.getAnnotation(RequestMapping.class);
        if (!ObjectUtils.isEmpty(annotation)) {
            if ("/file".equals(annotation.value()[0])) return;
        }
        JSONArray queryParams = JSONObject.parseArray(JSON.toJSONString(joinPoint.getArgs()));
        String userName;
        if (queryParams.size() == 0) {
            userName = "用户没有登录";
        } else {
            userName = queryParams.stream().filter(item -> (item instanceof JSONObject) && ((JSONObject) item).containsKey("newUser")).map(item -> ((JSONObject) item).getJSONObject("newUser").getString("codeName")).findFirst().orElse("用户没有登录");
        }
        log.info("登录用户：{}\t访问方法：{}\t请求参数：{}\t", userName, methodName, queryParams.toString());
    }

    @AfterThrowing(pointcut = "pointCut()")
    public void logAfterReturnThrow(JoinPoint joinPoint) {
        log.error("发生异常{}", joinPoint.getTarget());
    }
}
