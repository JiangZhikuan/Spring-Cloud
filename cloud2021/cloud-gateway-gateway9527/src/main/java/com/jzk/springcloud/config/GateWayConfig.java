package com.jzk.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:GateWayConfig
 * Package:com.jzk.springcloud.config
 * Description:
 *
 * @Date:2021/3/6 11:52
 * @Author:JZK
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_guonei",
                r -> r.path("/guonei")
                        .uri("https://news.baidu.com/guonei")).build();
        routes.route("path_route_guoji",r->r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
