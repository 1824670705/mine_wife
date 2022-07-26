package com.oa.application.log.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@TableName("oa_log")
@Accessors(chain = true)
public class Log {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long logId;

    /**
     * 日志内容
     */
    private String logContent;

    /**
     * 日志模块
     */
    private String logModule;
    private Long logOpUserId;
    private String logOpUserName;

    /**
     * 日志类型
     * {@link com.oa.utils.constans.LogConstant.LogTypeConstant}
     */
    private Integer logType;

    /**
     * 创建者
     */
    private Integer createBy;

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
}
