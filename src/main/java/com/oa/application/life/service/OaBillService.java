package com.oa.application.life.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.life.entity.bo.OaBill;
import com.oa.application.life.entity.dto.OaBillListDto;
import com.oa.application.life.entity.vo.OaBillVo;

public interface OaBillService extends IService<OaBill> {

    /**
     * 账单保存
     *
     * @param oaBill 账单
     */
    Object saveBill(OaBill oaBill);

    /**
     * 分页查询账单数据
     *
     * @param oaBillListVo 请求体
     * @return 分页数据
     */
    Page<OaBillVo> getList(OaBillListDto oaBillListVo);
}
