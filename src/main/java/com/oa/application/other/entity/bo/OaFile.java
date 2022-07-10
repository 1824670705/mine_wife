package com.oa.application.other.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (OaFile)实体类
 *
 * @author makejava
 * @since 2022-07-10 18:05:06
 */
@Data
@TableName("oa_file")
public class OaFile implements Serializable {
    private static final long serialVersionUID = -42340744912801444L;
    /**
     * 文件主键
     */
    @TableId(value = "field_id", type = IdType.ASSIGN_ID)
    private Long fileId;
    /**
     * 文件原始名字
     */
    private String fileOriginName;
    /**
     * 文件的唯一加密值
     */
    private String fileEncryption;
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
     * 文件路径
     */
    private String fileUrl;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 创建者
     */
    private Long ownerId;
    /**
     * 创建者名字
     */
    private String ownerName;
}

