package cn.vesns.common.utils.constant.oauth;

import lombok.Getter;

/**
 * @author: vesns vip865047755@126.com
 * @Title: Oauth2Enum
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 20:26
 */
@Getter
public enum Oauth2Enum {
    INVALID_TOKEN(4700, "无效token"),

    OAUTH_EXCEPTION(4701, "oauth未知错误"),

    LOGOUT_EXCEPTION(4702, "登出失败，token空");

    private Integer code;
    private String msg;

    Oauth2Enum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
