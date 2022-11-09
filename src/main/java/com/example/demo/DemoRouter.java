package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class DemoRouter {

    @Bean
    public RouterFunction<ServerResponse> route(DemoController demoController) {

        return RouterFunctions
                .route(POST("/api/matches").and(accept(MediaType.APPLICATION_JSON)), demoController::createMatch);
    }
}
