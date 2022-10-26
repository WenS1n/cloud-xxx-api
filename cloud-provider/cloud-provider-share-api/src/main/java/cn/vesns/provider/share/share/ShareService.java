package cn.vesns.provider.share.share;

import cn.vesns.provider.share.pojo.Share;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author: vesns vip865047755@126.com
 * @Title: Service
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:37
 */
public interface ShareService {


    /**
     * 测试
     *
     * @param string
     * @return {@link String}
     */
    String getString(String string);

    /**
     * 测试
     *
     * @param page
     * @return {@link Page<Share>}
     */
    Page<Share> findAll(Page page);

}

