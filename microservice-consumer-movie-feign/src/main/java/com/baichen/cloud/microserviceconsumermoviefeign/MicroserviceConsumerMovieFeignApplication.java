package com.baichen.cloud.microserviceconsumermoviefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient(autoRegister = false)
public class MicroserviceConsumerMovieFeignApplication {

    @Bean
    public RestTemplate testTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignApplication.class, args);
    }

}
