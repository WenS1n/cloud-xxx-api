package cn.vesns.provider.share.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: vesns vip865047755@126.com
 * @Title: Share
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "share分享表")
@TableName("share")
public class Share {


    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "序号", required = true)
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", required = true)
    private Integer userId;

    /**
     * 分享类型（1：文章/2：文档）
     */
    @ApiModelProperty(value = "分享类型（1：文章/2：文档）", required = true)
    private Byte type;

    /**
     * 状态值（0：删除/1：非删除）
     */
    @ApiModelProperty(value = "状态值（0：删除/1：非删除）", required = true)
    private Byte status;

    /**
     * 分享属性（0:原创/1:转载）
     */
    @ApiModelProperty(value = "分享属性（0：原创/1：转载）", required = true)
    private Byte property;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", required = true)
    private String title;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介", required = true)
    private String synopsis;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容", required = true)
    private String content;

    /**
     * 标签id
     */
    @ApiModelProperty(value = "标签id", required = true)
    private String labelId;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", required = true)
    private Integer classifyId;

    /**
     * 浏览次数
     */
    @ApiModelProperty(value = "浏览次数", required = true)
    private Integer visitsNum;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间", required = true)
    private Date operateTime;

}
