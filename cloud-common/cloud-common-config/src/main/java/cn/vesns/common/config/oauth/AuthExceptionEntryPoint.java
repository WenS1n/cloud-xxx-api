package cn.vesns.common.config.oauth;

import cn.vesns.common.JsonUtil;
import cn.vesns.common.Result;
import cn.vesns.common.utils.constant.oauth.Oauth2Enum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: vesns vip865047755@126.com
 * @Title: AuthExceptionEntryPoint
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:13
 */
@Component
@Slf4j
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException a) {
        Throwable cause = a.getCause();

        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        log.error(a.getMessage());
        log.error(a.toString());
        try {
            if (cause instanceof InvalidTokenException) {
                httpServletResponse.getWriter().write(Objects.requireNonNull(JsonUtil.toJson(Result.failure(Oauth2Enum.INVALID_TOKEN.getCode(),
                        Oauth2Enum.INVALID_TOKEN.getMsg(), "Token错了"))));
            } else {
                httpServletResponse.getWriter().write(Objects.requireNonNull(JsonUtil.toJson(Result.failure(Oauth2Enum.INVALID_TOKEN.getCode(),
                        Oauth2Enum.INVALID_TOKEN.getMsg(), "Token不存在or各种原因"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
