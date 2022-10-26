package cn.vesns.business.oauth2.controller;

import cn.vesns.business.oauth2.dto.LoginParam;
import cn.vesns.business.oauth2.dto.RegisterUserDTO;
import cn.vesns.business.oauth2.service.SsoService;
import cn.vesns.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: vesns vip865047755@126.com
 * @Title: SSOController
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:59
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/oauth/user")
@Slf4j
@Api(value = "单点登录")
public class SsoController {


    @Resource
    private SsoService ssoService;

    /**
     * 登录
     * @param loginParam
     * @return {@link Result}
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam) {
        return ssoService.login(loginParam);
    }

    @ApiOperation("注册账号")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterUserDTO registerUserDTO) {
        return ssoService.register(registerUserDTO);
    }

    /**
     * 登录完成 获取用户信息
     *
     * @return {@link Result}
     */
    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result getInfo() {
        return ssoService.getInfo();
    }

    /**
     * 登出
     *
     * @param request
     * @return {@link Result}
     */
    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        return ssoService.logout(request);
    }
}
