package com.baichen.cloud.microserviceconsumermovieribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient(autoRegister = false)
public class MicroserviceConsumerMovieApplication {

    @Bean
    @LoadBalanced
    public RestTemplate testTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieApplication.class, args);
    }

}
