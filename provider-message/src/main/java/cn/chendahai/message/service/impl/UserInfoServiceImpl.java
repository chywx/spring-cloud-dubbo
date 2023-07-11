package cn.chendahai.message.service.impl;


import cn.chendahai.entity.UserInfo;
import cn.chendahai.service.UserInfoService;
import org.apache.dubbo.config.annotation.DubboService;

//@DubboService(version = "${dubbo.version}")
@DubboService
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public UserInfo getById(Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("陈海洋：" + id);
        return userInfo;
    }
}
