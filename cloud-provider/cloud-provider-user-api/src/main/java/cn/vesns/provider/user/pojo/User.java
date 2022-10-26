package cn.vesns.provider.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: vesns vip865047755@126.com
 * @Title: User
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@ApiModel("用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "序号", required = true)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", required = true)
    private String nickname;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间", required = true)
    private Date operateTime;

    /**
     * 盐
     */
//    @ApiModelProperty(value = "盐", required = true)
//    private String salt;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", required = true)
    private String status;


}
