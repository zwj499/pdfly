package com.security.pdfly;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PdflyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdflyApplication.class, args);
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
