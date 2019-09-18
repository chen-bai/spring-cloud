package com.baichen.cloud.microserviceconsumermoviefeigncustomizing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableFeignClients(defaultConfiguration = DefaultRibbonConfig.class)
@EnableDiscoveryClient
public class MicroserviceConsumerMovieFeignCustomizingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignCustomizingApplication.class, args);
    }

}
