package cn.vesns.common.config.oauth;


import cn.vesns.common.JsonUtil;
import cn.vesns.common.Result;
import cn.vesns.common.utils.constant.oauth.Oauth2Enum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author arctique
 * @date 2020/10/28 11:27
 */
@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException a) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            httpServletResponse.getWriter().write(Objects.requireNonNull(JsonUtil.toJson(Result
                    .failure(Oauth2Enum.INVALID_TOKEN.getCode(),
                            Oauth2Enum.INVALID_TOKEN.getMsg(), "权限不足"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
