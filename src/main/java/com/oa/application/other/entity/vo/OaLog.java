package com.oa.application.other.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("oa_log")
public class OaLog {

    /**
     * 日志 Id
     */
    private Long logId;

    /**
     * 日志内容
     */
    private String logContent;

    /**
     * 日志模块
     */
    private String logModule;

    /**
     * 日志操作人 Id
     */
    private Long logOpUserId;

    /**
     * 日志操作人
     */
    private String logOpUserName;

    /**
     * 日志类型
     */
    private String logType;

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
