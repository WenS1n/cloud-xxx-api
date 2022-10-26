package cn.vesns.buisness.share.controller;

import cn.vesns.common.Result;
import cn.vesns.provider.share.share.ShareService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: vesns vip865047755@126.com
 * @Title: ShareController
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 22:24
 */
@RestController
@RequestMapping("/share")
@Api("share")
public class ShareController {

    @Reference(version = "1.0.0")
    private ShareService shareService;

    /**
     * 测试接口 hello world
     *
     * @param string
     * @return {@link Result}
     */
    @ApiOperation(value = "看个der1")
    @GetMapping("/getString")
    public Result getString(String string) {
        return Result.success(HttpStatus.OK.value(), "测试成功", shareService.getString(string));
    }


    /**
     * 测试接口 链接数据库 分页查找share表中的所有数据
     *
     * @param page
     * @return {@link Result}
     */
    @ApiOperation(value = "看个der2")
    @GetMapping("/findAll")
    public Result findAll(Page page) {
        return Result.success(HttpStatus.OK.value(), "测试成功", shareService.findAll(page));
    }
}
