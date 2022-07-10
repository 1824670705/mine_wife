package com.oa.application.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.other.service.IOaAreaService;
import com.oa.application.user.entity.bo.OaUser;
import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import com.oa.application.user.service.OaUserService;
import com.oa.application.user.vo.OaUserListVo;
import com.oa.domain.mapper.OaUserMapper;
import com.oa.domain.security.token.TokenUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("oaUserService")
public class OaUserServiceImpl extends ServiceImpl<OaUserMapper, OaUser> implements OaUserService {

    @Resource
    private IOaAreaService iOaAreaService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Page<OaUser> getList(OaUserListVo userListVo) {
        Page<OaUser> page = new Page<>(userListVo.getPageIndex(), userListVo.getPageSize());
        Page<OaUser> listPage = baseMapper.getList(page, userListVo);
        listPage.setRecords(listPage.getRecords().stream().peek(v -> v.setLocationId(iOaAreaService.getFullAreaName(v.getLocationId(), "-"))).collect(Collectors.toList()));
        return listPage;
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @return 令牌信息
     */
    @Override
    public OaUserLoginResponseVo login(String username) {
        OaUserLoginResponseVo userLoginBaseInfo = baseMapper.login(username);
        String token = TokenUtils.createToken(userLoginBaseInfo);
        userLoginBaseInfo.setToken(token);
        return userLoginBaseInfo;
    }

    @Override
    public Object registerUser(OaUser oaUser) {
        // 默认头像
        if (ObjectUtils.isEmpty(oaUser.getAvatar()))
            oaUser.setAvatar("[\"http://129.151.117.242:9000/oa-wife/2022/06/15/1655261196873_20170310223301qj0sqxi3mnr97558.jpg\"]");
        // 自动生成账户
        oaUser.setAccount("oa" + UUID.randomUUID().toString().replace("-", "").substring(0, 6));
        // 密码加密
        oaUser.setPassword(bCryptPasswordEncoder.encode(oaUser.getPassword()));
        return save(oaUser);
    }

    @Override
    public Boolean deleteUser(List<Long> userIds) {
        if (!ObjectUtils.isEmpty(userIds)) return removeByIds(userIds);
        return false;
    }
}
