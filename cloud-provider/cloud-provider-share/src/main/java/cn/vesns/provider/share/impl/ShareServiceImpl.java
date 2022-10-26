package cn.vesns.provider.share.impl;

import cn.vesns.provider.share.mapper.ShareMapper;
import cn.vesns.provider.share.pojo.Share;
import cn.vesns.provider.share.share.ShareService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author: vesns vip865047755@126.com
 * @Title: ShareSerrviceImpl
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 22:40
 */
@Service(version = "1.0.0")
@Slf4j
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {


    @Resource
    private ShareMapper shareMapper;

    @Override
    public String getString(String string) {
        return "测试成功 " + string;
    }

    @Override
    public Page<Share> findAll(Page page) {
        return shareMapper.findAll(page);
    }
}
