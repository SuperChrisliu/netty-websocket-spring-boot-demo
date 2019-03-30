### 简介
将[netty-websocket-Server](https://github.com/YeautyYE/netty-websocket-spring-boot-starter "netty-websocket-spring-boot-starter")注册到EurekaServer的demo

### 启动
分别启动`eureka-server（端口：8761）`，`gateway（端口：8777）`，`ws-service（端口：8779）`三个项目.

`eureka-server`是注册中心，`gateway`、`ws-service`、`push-service`启动后都会注册到这。`eureka-server`提供了RESTAPI：`http://localhost:8761/eureka/apps`获取当前`eureka-server`已注册的服务，在三个项目都启动好后，访问这个链接可以看到已经注册的三个实例。

`ws-service`应用为普通springboot web应用，它提供了websocket测试客户端网页版，应用名为`push-service`，可以在浏览器中访问链接：`http://localhost:8777/push-service/`，这里是通过网关访问界面。

`ws-service`同时集成了[netty-websocket-spring-boot-starter](https://github.com/YeautyYE/netty-websocket-spring-boot-starter "netty-websocket-spring-boot-starter")，在启动`ws-service`应用时，同时也启动了配置的websocket服务，路径为`/websocket`，端口为`8787`。websocket应用注册到`eureka-server`的名称为`ws-service`，那么通过网关访问websocket服务的链接为`ws://localhost:8777/ws-service/websocket`

### 感谢
[netty-websocket-spring-boot-starter](https://github.com/YeautyYE/netty-websocket-spring-boot-starter "netty-websocket-spring-boot-starter")

websocket网页版测试客户端：https://juejin.im/post/5baf20525188255c425837ad
