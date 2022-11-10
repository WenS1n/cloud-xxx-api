package cn.vesns.business.oauth2.service.impl;

import cn.vesns.business.oauth2.dto.LoginInfo;
import cn.vesns.business.oauth2.dto.LoginParam;
import cn.vesns.business.oauth2.dto.RegisterUserDTO;
import cn.vesns.business.oauth2.service.SsoService;
import cn.vesns.common.JsonUtil;
import cn.vesns.common.OkHttpUtil;
import cn.vesns.common.Result;
import cn.vesns.common.utils.constant.CommonConstants;
import cn.vesns.provider.user.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author: vesns vip865047755@126.com
 * @Title: SsoServiceImpl
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 22:02
 */
@Service
@Slf4j
public class SsoServiceImpl implements SsoService {

    private final String PORT = "9999";

    @Value("${server.servlet.context-path}")
    private String name;

    private final String grantType = "password";

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Resource(name = "userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private TokenStore tokenStore;

    @Override
    public Result register(RegisterUserDTO registerUserDTO) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, registerUserDTO.getUsername());


        return null;
    }

    /**
     * 登录
     *
     * @param loginParam
     * @return {@link Result}
     */
    @Override
    public Result login(LoginParam loginParam) {
        Map<String, String> token = Maps.newHashMap();
        // 先验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        log.info("password------------>{}",userDetails.getPassword());
        if (userDetails != null && bCryptPasswordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            // 获取token
            token.put(CommonConstants.AUTHORIZATION, getToken(loginParam));
        }
        return userDetails != null && bCryptPasswordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())
                ? Result.success(HttpStatus.OK.value(), "登录成功", token)
                : Result.failure(CommonConstants.REST_FAIL, "账号/密码错误", null);
    }

    /**
     * 获取登录用户信息
     *
     * @return {@link Result}
     */
    @Override
    public Result getInfo() {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication==========>{}",authentication);
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername(authentication.getName());

        return Result.success(HttpStatus.OK.value(), "获取用户信息", loginInfo);
    }


    /**
     * 登出
     *
     * @param request
     * @return {@link Result}
     */
    @Override
    public Result logout(HttpServletRequest request) {
        String token = request.getParameter(CommonConstants.AUTHORIZATION);
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);

        // 删除token
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return Result.success(HttpStatus.OK.value(), "用户注销");
    }

    /**
     * 获取token
     *
     * @param loginParam
     * @return {@link String}
     */
    private String getToken(LoginParam loginParam) {
        final String URL = String.format("http://localhost:%s%s%s", PORT, name, "/oauth/token");

        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", grantType);
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        log.info("URL---------->{}", URL);
        String post = OkHttpUtil.post(URL, params);

        return Objects.requireNonNull(JsonUtil.toMap(post)).get(CommonConstants.AUTHORIZATION).toString();
    }

}
