/*
 * Copyright (c) 2021 Duy. Free For Learning.
 */

package spring.microservice.discoveryservice;

/**
 * @author Duy Trần Thế
 * @version 1.0
 * @datetime 9/17/2021 12:53 AM
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

}
