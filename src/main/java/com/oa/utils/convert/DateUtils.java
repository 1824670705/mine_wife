package com.oa.utils.convert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 时间工具
 *
 * @author L
 * @date 2022/07/13 15:28
 */
public class DateUtils {

    public static Date getNowDate() {
        return Date.from(getNowLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime getNowLocalDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDate getNowLocalDate() {
        return LocalDate.now();
    }

    public static Date convertDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String getNowDateByString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(getNowLocalDateTime());
    }

    public static String getDateByStringAndPlus(ChronoUnit chronoUnit, Long value) {
        LocalDateTime localDateTime = getNowLocalDateTime().plus(value, chronoUnit);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

    public static String getDateByStringAndMinus(ChronoUnit chronoUnit, Long value) {
        LocalDateTime localDateTime = getNowLocalDateTime().minus(value, chronoUnit);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
