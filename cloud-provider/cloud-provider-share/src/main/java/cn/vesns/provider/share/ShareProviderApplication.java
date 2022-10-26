package cn.vesns.provider.share;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: vesns vip865047755@126.com
 * @Title: ShareProviderApplication
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 22:55
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.vesns.provider.share.mapper")
public class ShareProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShareProviderApplication.class, args);
    }
}
