package com.imhui.gateway.filter;

import com.imhui.gateway.common.ResponseResult;
import com.imhui.gateway.common.ResponseUtil;
import com.imhui.gateway.common.enums.ResponseCodeEnum;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class AuthenticationFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private String getAuthHeader(ServerHttpRequest request){
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private Mono<Void> onError(ServerWebExchange exchange, ResponseCodeEnum responseCode){
        ServerHttpResponse response = exchange.getResponse();
        ResponseResult result = ResponseUtil.fail(responseCode);

//        return response.writeAndFlushWith(result);
        return response.setComplete();
    }
}
