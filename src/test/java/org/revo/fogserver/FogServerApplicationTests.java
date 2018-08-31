package org.revo.fogserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.revo.fogserver.Domain.Message;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FogServerApplicationTests {

    @Test
    public void contextLoads() {
    }
}
