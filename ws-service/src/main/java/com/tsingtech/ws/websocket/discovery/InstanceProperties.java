package com.tsingtech.ws.websocket.discovery;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: chrisliu
 * Date: 2019/3/30 17:13
 * Mail: gwarmdll@gmail.com
 */
@Component
@Data
@ConfigurationProperties(InstanceProperties.PREFIX)
public class InstanceProperties {

    public static final String PREFIX = "netty-websocket.discovery.client";

    String host;
    Integer port;
    String name;
}
