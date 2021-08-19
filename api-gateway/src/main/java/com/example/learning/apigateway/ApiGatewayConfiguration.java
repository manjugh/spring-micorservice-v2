package com.example.learning.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gateWayRouter(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(urlPath -> urlPath.path("/get").uri("http://httpbin.org:80"))
                .route(urlPath -> urlPath.path("/currency-exchange/**").uri("lb://currency-exchange"))
                .route(urlPath -> urlPath.path("/currency-conversion/**").uri("lb://currency-conversion"))
                .route(urlPath -> urlPath.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
                .route(urlPath -> urlPath.path("/currency-conversion-new/**").filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)","/currency-conversion-feign/${segment}")).uri("lb://currency-conversion"))
                .build();
    }
}
