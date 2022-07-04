package com.oa.utils.convert;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String, Date> {

    @Override
    @SneakyThrows
    public Date convert(@Nullable String source) {
        Assert.isTrue(!ObjectUtils.isEmpty(source), "参数异常");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(source);
    }
}
