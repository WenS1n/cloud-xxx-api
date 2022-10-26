package cn.vesns.provider.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: vesns vip865047755@126.com
 * @Title: UserApplication
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:49
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.vesns.provider.user.mapper")
public class UserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }

}
