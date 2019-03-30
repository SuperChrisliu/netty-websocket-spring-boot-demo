package com.tsingtech.ws.websocket.discovery;

import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.tsingtech.ws.utils.BeanUtil;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Author: chrisliu
 * Date: 2019/2/21 17:13
 * Mail: gwarmdll@gmail.com
 */
public class InstanceConfig extends MyDataCenterInstanceConfig {

    @Override
    public String getHostName(boolean refresh) {
        return BeanUtil.getBean(InstanceProperties.class).getHost();
    }

    @Override
    public int getNonSecurePort(){
        int tomcatPort;
        try {
            MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                    Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));

            tomcatPort = Integer.valueOf(objectNames.iterator().next().getKeyProperty("port"));
        }catch (Exception e){
            return super.getNonSecurePort();
        }
        return tomcatPort;
    }
}
