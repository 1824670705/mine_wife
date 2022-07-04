package com.oa.application.goods.vo;

import com.oa.utils.validate.Default;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class GoodsDeleteVo implements Serializable {

    /**
     * 单品 Id
     */
    @NotNull(message = "订单Id不可以为空", groups = {Default.class})
    private Long goodsId;
}
