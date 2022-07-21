package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.goods.entity.bo.Goods;
import com.oa.application.goods.entity.vo.GoodsDto;
import com.oa.application.goods.entity.vo.GoodsListDto;
import org.apache.ibatis.annotations.Param;

public interface OaGoodsMapper extends BaseMapper<Goods> {

    Page<GoodsDto> getList(Page<GoodsDto> page, @Param("goodsListVo") GoodsListDto goodsListVo);
}
