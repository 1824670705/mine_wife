package com.oa.domain.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oa.application.log.entity.bo.Log;
import com.oa.application.log.service.LogService;
import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import com.oa.domain.security.token.TokenUtils;
import com.oa.utils.constans.LogConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
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
        JoinPointInfo loginUserInfo = getLoginUserInfo(joinPoint);
        if (ObjectUtils.isEmpty(loginUserInfo)) {
            log.error("未知日志");
        } else {
            saveLog(loginUserInfo.getOaUserLoginResponseVo(), loginUserInfo.getMethodName(), loginUserInfo.getParams(), loginUserInfo.getTargetClass());
            log.info("登录用户：{}\t访问方法：{}\tAmazonDateUtils请求参数：{}\t", loginUserInfo.getUsername(), loginUserInfo.getMethodName(), loginUserInfo.getParams());
        }
    }

    private void saveLog(OaUserLoginResponseVo loginResponseVo, String method, String params, Class<?> targetClass) {
        Log logBean = new Log();
        for (LogConstant.LogModuleConstant moduleConstant : LogConstant.LogModuleConstant.values()) {
            if (moduleConstant.getModuleController() == targetClass) {
                // 逻辑处理
                logBean.setLogModule(moduleConstant.getDesc());
                break;
            }
        }
        if (ObjectUtils.isEmpty(loginResponseVo)) {
            logBean.setLogOpUserName("用户未登录").setLogOpUserId(0L).setLogContent(method + "=>" + params)
                    .setCreateBy(0L).setLogType(LogConstant.LogTypeConstant.defaultType).setLogTypeName(LogConstant.LogTypeConstant.defaultTypeName);
        } else {
            logBean.setLogOpUserName(loginResponseVo.getUsername()).setLogOpUserId(loginResponseVo.getUserId()).setLogContent(method + "=>" + params)
                    .setCreateBy(loginResponseVo.getUserId()).setLogType(LogConstant.LogTypeConstant.defaultType).setLogTypeName(LogConstant.LogTypeConstant.defaultTypeName);
        }
        logService.save(logBean);
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void logAfterReturnThrow(JoinPoint joinPoint, Exception e) {
        JoinPointInfo loginUserInfo = getLoginUserInfo(joinPoint);
        if (ObjectUtils.isEmpty(loginUserInfo)) {
            log.error("发生异常并且不会保存日志到数据库中\t=>\t{}", e.getMessage());
            return;
        }
        saveLog(loginUserInfo.getOaUserLoginResponseVo(), loginUserInfo.getMethodName(), loginUserInfo.getParams(), loginUserInfo.getTargetClass());
        log.error("发生异常\t=>\t{}", e.getMessage());
    }

    /**
     * parse joinPoint 获取 join point about user info and method info or target conrtoll class info
     *
     * @param joinPoint 方法和类信息
     */
    private JoinPointInfo getLoginUserInfo(JoinPoint joinPoint) {
        JoinPointInfo info = new JoinPointInfo();
        String methodName = joinPoint.getSignature().getName();
        info.setMethodName(methodName);
        Class<?> aClass = joinPoint.getTarget().getClass();
        info.setTargetClass(aClass);
        RequestMapping annotation = aClass.getAnnotation(RequestMapping.class);
        if (!ObjectUtils.isEmpty(annotation)) {
            if ("/file".equals(annotation.value()[0])) return null;
        }
        JSONArray queryParams = JSONObject.parseArray(JSON.toJSONString(joinPoint.getArgs()));
        info.setParams(queryParams.toJSONString());
        String userName;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (queryParams.size() == 0) {
            try {
                Object principal = authentication.getPrincipal();
                userName = String.valueOf(principal);
                OaUserLoginResponseVo loginResponseVo = TokenUtils.parseToken(String.valueOf(authentication.getCredentials()));
                info.setOaUserLoginResponseVo(loginResponseVo);
            } catch (Exception e) {
                userName = "用户没有登录";
            }
        } else {
            Object principal = authentication.getPrincipal();
            userName = String.valueOf(principal);
            OaUserLoginResponseVo loginResponseVo = TokenUtils.parseToken(String.valueOf(authentication.getCredentials()));
            info.setOaUserLoginResponseVo(loginResponseVo);
        }
        info.setUsername(userName);
        return info;
    }

    @Data
    static class JoinPointInfo {

        /**
         * 方法名
         */
        private String methodName;

        /**
         * 用户名
         */
        private String username;

        /**
         * 当前登录用户信息
         */
        private OaUserLoginResponseVo oaUserLoginResponseVo;

        /**
         * 当前访问的类
         */
        private Class<?> targetClass;

        /**
         * 参数信息
         */
        private String params;
    }
}
