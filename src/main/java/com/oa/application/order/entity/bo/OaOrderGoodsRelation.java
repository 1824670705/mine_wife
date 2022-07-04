package com.oa.application.order.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("oa_order_goods_relation")
public class OaOrderGoodsRelation implements Serializable {

    /**
     * 关联 Id
     */
    @TableId("relation_id")
    private Long relationId;

    /**
     * 订单 Id
     */
    private Long orderId;

    /**
     * 商品 Id
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除[0删除1没有删除]
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;
}
