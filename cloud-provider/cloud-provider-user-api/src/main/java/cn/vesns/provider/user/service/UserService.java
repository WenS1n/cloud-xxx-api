package cn.vesns.provider.user.service;

import cn.vesns.provider.user.pojo.User;

/**
 * @author: vesns vip865047755@126.com
 * @Title: ShareService
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:32
 */
public interface UserService {

    /**
     * 通过用户名查找用户信息
     *
     * @param username
     * @return {@link User}
     */
    User findOne(String username);
}
