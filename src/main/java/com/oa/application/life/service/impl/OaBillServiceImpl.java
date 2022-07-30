package com.oa.application.life.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.life.entity.bo.OaBill;
import com.oa.application.life.entity.dto.OaBillListDto;
import com.oa.application.life.entity.vo.OaBillVo;
import com.oa.application.life.service.OaBillService;
import com.oa.application.other.service.IOaAreaService;
import com.oa.domain.mapper.OaBillMapper;
import com.oa.utils.other.LoginUserInfoUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class OaBillServiceImpl extends ServiceImpl<OaBillMapper, OaBill> implements OaBillService {

    @Resource
    private IOaAreaService iOaAreaService;

    @Override
    public Object saveBill(OaBill oaBill) {
        // 设置保存参数 --》 完整地址信息
        Optional.ofNullable(oaBill.getLocalLastId()).ifPresent(localId -> oaBill.setLocalFullName(iOaAreaService.getFullAreaName(localId, "-")));
        oaBill.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        return save(oaBill);
    }

    @Override
    public Page<OaBillVo> getList(OaBillListDto oaBillListVo) {
        Page<OaBill> page = new Page<>(oaBillListVo.getPageIndex(), oaBillListVo.getPageSize());
        oaBillListVo.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        return baseMapper.getList(page, oaBillListVo);
    }

    @Override
    public boolean update(OaBill oaBill) {
        return updateById(oaBill);
    }
}
