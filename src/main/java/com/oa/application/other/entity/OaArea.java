package com.oa.application.other.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author L
 * @since 2022-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oa_area")
public class OaArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 区域代码
     */
    private String areaCode;

    /**
     * 地点名字
     */
    private String areaName;

    /**
     * 父类Id，0代表最高级
     */
    private String areaParentCode;

    /**
     * 完整名称
     */
    private String areaFullName;

    /**
     * 完整code
     */
    private String areaFullCode;
}
