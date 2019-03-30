package com.tsingtech.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Author: chrisliu
 * Date: 2019/3/28 15:00
 * Mail: gwarmdll@gmail.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }
}
