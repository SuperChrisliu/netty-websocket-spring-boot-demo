package com.tsingtech.ws.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yeauty.standard.ServerEndpointExporter;

/**
 * Author: chrisliu
 * Date: 2019/3/28 14:44
 * Mail: gwarmdll@gmail.com
 */
@Configuration
public class Config {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
