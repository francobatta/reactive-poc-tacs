package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class DemoController {
    private final DemoRepository demoRepository;

    @Autowired
    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public Mono<ServerResponse> createMatch(ServerRequest request) {
        return request
                .bodyToMono(MatchInput.class)
                .delayElement(Duration.ofSeconds(1)) // introduce artificial delay, make benchmark fair in comparison to JWT request from other projects
                .flatMap(input -> demoRepository.save(
                        Match.builder()
                                .place(input.getPlace())
                                .time(input.getTime())
                                .date(input.getDate())
                                .build()
                ))
                .flatMap(saved ->
                        ServerResponse.ok().bodyValue(CreateMatchResponse.builder()
                                .id(saved.getId())
                                .build())
                );
    }
}
