package cn.vesns.business.oauth2.service;

import cn.vesns.business.oauth2.dto.LoginParam;
import cn.vesns.business.oauth2.dto.RegisterUserDTO;
import cn.vesns.common.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: vesns vip865047755@126.com
 * @Title: SsoService
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 22:01
 */
public interface SsoService {


    /**
     * 登录
     *
     * @param loginParam
     * @return {@link Result}
     */
    Result login(LoginParam loginParam);

    /**
     * 获取登录用户信息
     *
     * @return {@link Result}
     */
    Result getInfo();

    /**
     * 登出
     *
     * @param request
     * @return {@link Result}
     */
    Result logout(HttpServletRequest request);

    Result register(RegisterUserDTO registerUserDTO);

}
