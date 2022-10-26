package cn.vesns.business.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;

/**
 * @author: vesns vip865047755@126.com
 * @Title: Oauth2Config
 * @ProjectName: cloud-xxx-api
 * @Description:
 * @date: 2022-10-24 21:53
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 注入用于 password 模式
     */
    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * access_token 的存储方式
     *
     * @return {@link TokenStore}
     */
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    /**
     * 用于支持密码模式
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore());
    }

    /**
     * 允许客户端访问 /oauth/check_token 检查token
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }


    /**
     * 配置客户端
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                // 使用内存设置
                .inMemory()
                // 客户端id
                .withClient("client")
                // 客户端密钥
                .secret(passwordEncoder.encode("secret"))
                // 授权类型：密码模式和刷新令牌
                .authorizedGrantTypes("password")
                // 授权范围
                .scopes("web")
                // 可以设置对哪些资源有效访问权限，不设置则全部资源都可以访问
                .resourceIds("oauth2-resources")
                // 设置访问令牌的有效时间：1天
                .accessTokenValiditySeconds(60 * 60 * 24);
        // 设置刷新令牌的有效时间：1个月
//                .refreshTokenValiditySeconds(60 * 60 * 24 * 30);

        // client信息保存方式:通过jdbc保存进数据库
//        clients.withClientDetails(jdbcClientDetails());
    }
}
