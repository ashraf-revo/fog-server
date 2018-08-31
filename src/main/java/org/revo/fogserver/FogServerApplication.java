package org.revo.fogserver;

import org.revo.fogserver.Domain.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class FogServerApplication {
    private final RequestPredicate fog_server =

            GET("/");

    public static void main(String[] args) {
        SpringApplication.run(FogServerApplication.class, args);
    }

    @Bean
    public RouterFunction fog_route(@Value("classpath:/static/index.html") final Resource indexHtml, UnicastProcessor<Message> UProcessor, Flux<Message> queue) {
        return route(GET("/queue/recive"), request -> ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(queue, Message.class)).
                andRoute(POST("/queue/send"), request -> request.bodyToMono(Message.class).doOnNext(System.out::println).doOnNext(UProcessor::onNext).flatMap(it -> ok().build()))
                .andRoute(fog_server, request -> ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml));
    }
}
