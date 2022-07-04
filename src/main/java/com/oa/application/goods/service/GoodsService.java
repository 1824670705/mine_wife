package com.oa.application.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.goods.entity.Goods;
import com.oa.application.goods.vo.GoodsDeleteVo;
import com.oa.application.goods.vo.GoodsDto;
import com.oa.application.goods.vo.GoodsListDto;
import com.oa.application.goods.vo.GoodsSaveVo;

public interface GoodsService extends IService<Goods> {

    Page<GoodsDto> getList(GoodsListDto goodsListVo);

    Object saveData(GoodsSaveVo goodsSaveVo);

    /**
     * 删除单品
     *
     * @param goodsDeleteVo 单品删除
     */
    Boolean deleteData(GoodsDeleteVo goodsDeleteVo);
}
