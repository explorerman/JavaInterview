# Springboot整合API网关

## 网关基本概念

### API网关介绍

API 网关出现的原因是微服务架构的出现，不同的微服务一般会有不同的网络地址，而外部客户端可能 需要调用多个服务的接口才能完成一个业务需求，如果让客户端直接与各个微服务通信，会有以下的问题:

- 客户端会多次请求不同的微服务，增加了客户端的复杂性。

- 存在跨域请求，在一定场景下处理相对复杂。

- 认证复杂，每个服务都需要独立认证。

- 难以重构，随着项目的迭代，可能需要重新划分微服务。例如，可能将多个服务合并成一个或者将 一个服务拆分成多个。如果客户端直接与微服务通信，那么重构将会很难实施。

- 某些微服务可能使用了防火墙 / 浏览器不友好的协议，直接访问会有一定的困难。

以上这些问题可以借助 **API 网关解决**。**API 网关是介于客户端和服务器端之间的中间层，所有的外部请 求都会先经过 API 网关这一层**。也就是说，API 的实现方面更多的考虑业务逻辑，而安全、性能、监控 可以交由 API 网关来做，这样既提高业务灵活性又不缺安全性

### Spring Cloud Gateway

​			Spring cloud gateway是spring官方基于Spring 5.0、Spring Boot2.0和Project Reactor等技术开发的 网关，Spring Cloud Gateway旨在为微服务架构提供简单、有效和统一的API路由管理方式，Spring Cloud Gateway作为Spring Cloud生态系统中的网关，目标是替代Netflix Zuul，其不仅提供统一的路由方式，并且还基于Filter链的方式提供了网关基本的功能，例如:安全、监控/埋点、限流等。

![image-20200905152818607](Springboot%E5%AE%9E%E6%88%98%E2%80%94%E2%80%94API%E7%BD%91%E5%85%B3.assets/image-20200905152818607.png)

### Spring Cloud Gateway核心概念

​		网关提供API全托管服务，丰富的API管理功能，辅助企业管理大规模的API，以降低管理成本和安全风险，包括协议适配、协议转发、安全策略、防刷、流量、监控日志等贡呢。一般来说网关对外暴露 的URL或者接口信息，我们统称为路由信息。如果研发过网关中间件或者使用过Zuul的人，会知道网关的核心是Filter以及Filter Chain(Filter责任链)。Sprig Cloud Gateway也具有路由和Filter的概念。 下面介绍一下Spring Cloud Gateway中几个重要的概念。

- 路由。路由是网关最基础的部分，路由信息有一个ID、一个目的URL、一组断言和一组Filter组成。如果断言路由为真，则说明请求的URL和配置匹配

- 断言。Java8中的断言函数。Spring Cloud Gateway中的断言函数输入类型是Spring5.0框架中 的ServerWebExchange。Spring Cloud Gateway中的断言函数允许开发者去定义匹配来自于http request中的任何信息，比如请求头和参数等。

- 过滤器。一个标准的Spring webFilter。Spring cloud gateway中的filter分为两种类型的Filter，分别是Gateway Filter和Global Filter。过滤器Filter将会对请求和响应进行修改处理

![image-20200905153159606](Springboot%E5%AE%9E%E6%88%98%E2%80%94%E2%80%94API%E7%BD%91%E5%85%B3.assets/image-20200905153159606.png)

​		如上图所示，Spring cloud Gateway发出请求。然后再由Gateway Handler Mapping中找到与请求相匹配 的路由，将其发送到Gateway web handler。Handler再通过指定的过滤器链将请求发送到我们实际的服 务执行业务逻辑，然后返回。

