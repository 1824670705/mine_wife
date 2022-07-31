package com.oa.utils.convert;

import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * double parse format
 *
 * @author L
 */
public class DoubleFormat {

    /**
     * parse double to set scale(default 2)
     *
     * @param v double value
     * @return format complete result
     * @author L
     */
    public static double formatDouble(double v) {
        if (ObjectUtils.isEmpty(v) || Double.isNaN(v)) return 0.0;
        return BigDecimal.valueOf(v).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
