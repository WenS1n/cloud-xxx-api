package cn.vesns.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: vesns vip865047755@126.com
 * @Title: GatewayApplication
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:18
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        SecurityAutoConfiguration.class})
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
