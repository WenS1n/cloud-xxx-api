package cn.vesns.business.oauth2.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * 登录信息
 *
 * @author arctique
 * @date 2020/9/17 17:19
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo implements Serializable {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("头像")
    private String avatar;
}
