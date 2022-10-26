package cn.vesns.provider.share.mapper;

import cn.vesns.provider.share.pojo.Share;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: vesns vip865047755@126.com
 * @Title: ShareMapper
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 22:40
 */
@Mapper
public interface ShareMapper extends BaseMapper<Share> {

    /**
     * 测试
     *
     * @param page
     * @return {@link Page <Share>}
     */
    Page<Share> findAll(Page page);
}
