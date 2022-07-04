package com.oa.application.menu.vo;

import com.oa.utils.validate.Default;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class DelVo implements Serializable {

    /**
     * 要删除的节点id
     */
    @NotNull(message = "节点Id不可以为空", groups = {Default.class})
    private List<Long> delIds;

    /**
     * 是否是父节点
     */
    private Integer whetherParent;
}
