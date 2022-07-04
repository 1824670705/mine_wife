package com.oa.application.goods.vo;

import com.oa.utils.dto.ParentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class GoodsListDto extends ParentDto implements Serializable {

    /**
     * 商品标题 | 编号 | Id
     * 支持模糊搜索
     */
    private String searchKeyword;

    /**
     * 搜索类型
     * 【0：标题，1：编号，2：id】
     */
    private Integer searchType;

    /**
     * 订单状态
     */
    private Integer goodsStatus;
}
