package com.gateway.gatewayserver;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


public class AppConf {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes().route(

                r-> r.path("/DEPARTMENT-MS/**")
                        .filters(f->f.rewritePath("/DEPARTMENT-MS/?(?<remaining>.*)","/${remaining}"))
                        .uri("lb://DEPARTMENT-MS")

        ).build();

    }
}
