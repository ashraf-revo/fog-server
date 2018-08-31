package org.revo.fogserver.Config;

import org.revo.fogserver.Domain.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

@Configuration
public class Util {
    @Bean
    public UnicastProcessor<Message> UProcessor() {
        return UnicastProcessor.create();
    }

    @Bean
    public Flux<Message> queue(UnicastProcessor<Message> UProcessor) {
        return UProcessor.publish().autoConnect();
    }

}
