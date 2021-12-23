## Spring Cloud Demo
### 环境
> jdk11+

### eureka-server
> 服务注册中心  

### eureka-service-provider
> 服务。操作DB

### eureka-service-consume
> 消费者服务，通过feign 调用eureka-service-provider

### eureka-service-gateway
> 网关，服务熔断，负载均衡

### springcloud-config-server
> 配置中心，远端git配置
