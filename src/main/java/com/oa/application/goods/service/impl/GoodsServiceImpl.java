package com.oa.application.goods.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.goods.entity.bo.Goods;
import com.oa.application.goods.service.GoodsService;
import com.oa.application.goods.entity.vo.GoodsDeleteVo;
import com.oa.application.goods.entity.vo.GoodsDto;
import com.oa.application.goods.entity.vo.GoodsListDto;
import com.oa.application.goods.entity.vo.GoodsSaveVo;
import com.oa.domain.mapper.OaGoodsMapper;
import com.oa.domain.security.handler.LoginUserDetails;
import com.oa.utils.other.LoginUserInfoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;

@Service
public class GoodsServiceImpl extends ServiceImpl<OaGoodsMapper, Goods> implements GoodsService {

    /**
     * 分月查询数据
     *
     * @param goodsListVo 参数
     */
    @Override
    public Page<GoodsDto> getList(GoodsListDto goodsListVo) {
        Page<GoodsDto> page = new Page<>(goodsListVo.getPageIndex(), goodsListVo.getPageSize());
        goodsListVo.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        return baseMapper.getList(page, goodsListVo);
    }

    @Override
    public Object saveData(GoodsSaveVo goodsSaveVo) {
        // 设置图片的的默认值
        if (ObjectUtils.isEmpty(goodsSaveVo.getImgUrl()))
            goodsSaveVo.setImgUrl("[\"http://129.151.117.242:9000/oa-wife/2022/06/15/1655261196873_20170310223301qj0sqxi3mnr97558.jpg\"]");
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsSaveVo, goods);
        goods.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        return save(goods);
    }

    /**
     * 删除操作逻辑
     *
     * @param goodsDeleteVo 删除条件
     */
    @Override
    public Boolean deleteData(GoodsDeleteVo goodsDeleteVo) {
        // 逻辑删除数据
        return removeById(goodsDeleteVo.getGoodsId());
    }
}
