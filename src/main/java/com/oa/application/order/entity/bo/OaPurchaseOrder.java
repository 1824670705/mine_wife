package com.oa.application.order.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("oa_purchase_order")
public class OaPurchaseOrder implements Serializable {

    /**
     * 采购 Id
     */
    @TableId(value = "purchase_id")
    private Long purchaseId;

    /**
     * 采购类型
     * <p>
     * 【采购单品计划，采购文章计划】
     */
    private Integer purchaseType;

    /**
     * 采购计划开始时间
     */
    private Date pathStartTime;

    /**
     * 采购计划过期时间
     */
    private Date pathStartExpireTime;

    /**
     * 预计消费
     */
    private String estimateExpend;

    /**
     * 实际消费
     */
    private String realExpend;

    /**
     * 采购状态
     * <p>
     * 【待采购，采购中，采购完成，采购失败，采购取消】
     */
    private Integer status;

    /**
     * 备注
     */
    private String remake;

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
     * 逻辑删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;

    /**
     * 创建者
     */
    private Long createBy;
}
