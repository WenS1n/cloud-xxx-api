package cn.vesns.provider.user.impl;

import cn.vesns.provider.user.mapper.UserMapper;
import cn.vesns.provider.user.pojo.User;
import cn.vesns.provider.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author: vesns vip865047755@126.com
 * @Title: UserServiceImpl
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:40
 */
@Service(version = "1.0.0")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过用户名查找用户信息
     *
     * @param username
     * @return {@link User}
     */
    @Override
    public User findOne(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "1");
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }
}
