package cn.vesns.gateway.handler;

import cn.vesns.gateway.config.SwaggerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.*;

import java.util.List;
import java.util.Optional;

/**
 * @author arctique
 * @date 2020/9/19 11:00
 */
@RestController
public class SwaggerHandler {

    private final SecurityConfiguration securityConfiguration;
    private final UiConfiguration uiConfiguration;
    private final SwaggerProvider swaggerProvider;

    @Autowired
    public SwaggerHandler(SwaggerProvider swaggerProvider, SecurityConfiguration securityConfiguration, UiConfiguration uiConfiguration) {
        this.swaggerProvider = swaggerProvider;
        this.securityConfiguration = securityConfiguration;
        this.uiConfiguration = uiConfiguration;
    }

    @GetMapping("/swagger-resources/configuration/security")
    public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration() {
        return Mono.just(new ResponseEntity<>(
                Optional.ofNullable(securityConfiguration).orElse(SecurityConfigurationBuilder.builder().build()),
                HttpStatus.OK));
    }

    @GetMapping("/swagger-resources/configuration/ui")
    public Mono<ResponseEntity<UiConfiguration>> uiConfiguration() {
        return Mono.just(new ResponseEntity<>(
                Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()), HttpStatus.OK));
    }

    @GetMapping("/swagger-resources")
    public Mono<ResponseEntity<List<SwaggerResource>>> swaggerResources() {
        return Mono.just((new ResponseEntity<>(swaggerProvider.get(), HttpStatus.OK)));
    }

    @GetMapping("/")
    public Mono<ResponseEntity<List<SwaggerResource>>> swaggerResourcesN() {
        return Mono.just((new ResponseEntity<>(swaggerProvider.get(), HttpStatus.OK)));
    }

    @GetMapping("/csrf")
    public Mono<ResponseEntity> swaggerResourcesCsrf() {
        return Mono.just((new ResponseEntity<>(swaggerProvider.get(), HttpStatus.OK)));
    }
}
