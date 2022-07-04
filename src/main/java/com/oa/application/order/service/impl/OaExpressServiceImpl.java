package com.oa.application.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.order.entity.bo.OaExpress;
import com.oa.application.order.service.IOaExpressService;
import com.oa.domain.mapper.OaExpressMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Service
public class OaExpressServiceImpl extends ServiceImpl<OaExpressMapper, OaExpress> implements IOaExpressService {

}
