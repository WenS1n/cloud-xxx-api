package cn.vesns.business.oauth2.dto;

import lombok.Data;

/**
 * @author: vesns vip865047755@126.com
 * @Title: RegisterUserDTO
 * @ProjectName: parent
 * @Description:
 * @date: 2022-10-16 17:10
 */
@Data
public class RegisterUserDTO {

    private String username;

    private String password;

    private String nickname;
}
