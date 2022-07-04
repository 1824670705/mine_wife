package com.oa.utils.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class R implements Serializable {
    private Boolean success;

    private Integer code;

    private String message;

    private Object data = new Object();

    private R() {
    }

    public static R success() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(RCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(RCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(Object value) {
        this.data = value;
        return this;
    }

    public R data(Map<String, Object> map) {
        this.data = map;
        return this;
    }

}
