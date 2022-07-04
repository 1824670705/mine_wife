package com.oa.domain.exception;

import com.oa.utils.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ValidateExceptionHandler {

    /**
     * 实体对象校验时抛出的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleBindException(MethodArgumentNotValidException ex) {
        log.error("实体对象校验时抛出的异常\t->\t{}", ex.getMessage());
        //获取参数校验异常message
        String defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("；"));
        return R.error().data(defaultMsg);
    }

    /**
     * 单个参数校验时抛出的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BindException.class)
    public R handleBindGetException(BindException ex) {
        log.error("单个参数校验时抛出的异常\t->\t{}", ex.getMessage());
        //获取参数校验异常message
        String defaultMsg = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
        return R.error().data(defaultMsg);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public R allExceptionHandler(Exception e) {
        e.printStackTrace();
        return R.error().data(e.getMessage());
    }
}
