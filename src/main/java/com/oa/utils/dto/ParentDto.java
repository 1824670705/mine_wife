package com.oa.utils.dto;

import com.oa.utils.validate.Default;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class ParentDto implements Serializable {
    /**
     * 起始页
     */
    @NotNull(message = "起始页不可以为空", groups = {Default.class})
    private Integer pageIndex;

    /**
     * 分页大小
     */
    @NotNull(message = "分页大小不可以为空", groups = {Default.class})
    private Integer pageSize;

    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    private Date endDate;
}
