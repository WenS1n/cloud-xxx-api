package cn.vesns.business.oauth2.service;

import cn.vesns.common.JsonUtil;
import cn.vesns.provider.user.pojo.User;
import cn.vesns.provider.user.service.UserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: vesns vip865047755@126.com
 * @Title: UserDetailServiceImpl
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 22:02
 */
@Component
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 权限
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority userAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(userAuthority);

        // 用户信息
        User user = userService.findOne(username);
        log.info("user---------->{}", JsonUtil.toJson(user));

        // 判断用户名
        return user != null
                ? new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities)
                : null;
    }
}
