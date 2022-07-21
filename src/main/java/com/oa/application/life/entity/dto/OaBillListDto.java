package com.oa.application.life.entity.dto;

import com.oa.utils.dto.ParentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OaBillListDto extends ParentDto {

    /**
     * 创建者
     */
    private Long createBy;
}
