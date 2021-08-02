package com.imhui.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes().build();
    }
}
