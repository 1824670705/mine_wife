package com.oa.domain.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oa.application.log.entity.bo.Log;
import com.oa.application.log.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Slf4j
@Aspect
@Component
public class LogAop {

    @Resource(name = "logService")
    private LogService logService;

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
            try {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                userName = String.valueOf(principal);
            } catch (Exception e) {
                userName = "用户没有登录";
            }
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userName = String.valueOf(principal);
        }
        log.info("登录用户：{}\t访问方法：{}\t请求参数：{}\t", userName, methodName, queryParams.toString());
    }

    private void saveLog() {
        Log logBean = new Log();

        logService.save(logBean);
    }

    @AfterThrowing(pointcut = "pointCut()")
    public void logAfterReturnThrow(JoinPoint joinPoint) {
        log.error("发生异常{}", joinPoint.getTarget());
    }
}
