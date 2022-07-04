package com.oa.application.user.vo;

import com.oa.utils.validate.Default;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class OaDeleteSupplierVo implements Serializable {

    /**
     * 供应商主键 Id
     */
    @NotNull(message = "供应商主键 Id 不可以为空", groups = {Default.class})
    private Long supplierId;
}
