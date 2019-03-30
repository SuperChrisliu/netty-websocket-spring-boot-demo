package com.tsingtech.gateway.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Author: chrisliu
 * Date: 2019/3/2 9:46
 * Mail: gwarmdll@gmail.com
 */
@Configuration
public class CorsConfig {

    private static final String MAX_AGE = "86400";

    private static final String accessMethods = "OPTIONS, GET, HEAD, POST, PUT, PATCH, DELETE, TRACE";

    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                HttpHeaders requestHeaders = request.getHeaders();
                ServerHttpResponse response = ctx.getResponse();
                HttpHeaders headers = response.getHeaders();
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());

                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, accessMethods);
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

                headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    List<String> allHeaders = requestHeaders.getAccessControlRequestHeaders();
                    if (!CollectionUtils.isEmpty(allHeaders)) {
                        headers.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, allHeaders);
                    }
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };
    }
}
