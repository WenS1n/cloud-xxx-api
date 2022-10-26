package cn.vesns.common.config.mybatis;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: vesns vip865047755@126.com
 * @Title: MybatisPlusConfig
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 20:23
 */

@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {


    /**
     * MyBatis-Plus 分页插件
     *
     * @return {@link PaginationInterceptor}
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * Mybatis-Plus SQL注入器
     *
     * @return {@link ISqlInjector}
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
