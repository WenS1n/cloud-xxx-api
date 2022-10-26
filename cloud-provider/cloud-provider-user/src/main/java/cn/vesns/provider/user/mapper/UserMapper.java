package cn.vesns.provider.user.mapper;

import cn.vesns.provider.user.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * @author: vesns vip865047755@126.com
 * @Title: UserMapper.xml
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:41
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
