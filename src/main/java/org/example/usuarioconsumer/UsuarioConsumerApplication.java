package org.example.usuarioconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;

@SpringBootApplication
public class UsuarioConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuarioConsumerApplication.class, args);
    }



    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder
                .baseUrl("http://localhost:4000/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

@Bean
public WebClient.Builder webClientBuilder(){
    return WebClient.builder();
}

@Bean
public WebClient webClient(WebClient.Builder builder){
    return builder
            .baseUrl("http://localhost:4000/")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
}
