# SpringCloud
学习项目

spring cloud 为开发人员提供了快速构建分布式系统的一些工具，
包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等。
它运行环境简单，可以在开发人员的电脑上跑。
另外说明spring cloud是基于springboot的

断路器

在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），
在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。
为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，
如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，
Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，
会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。

为了解决这个问题，业界提出了断路器模型。
Netflix开源了Hystrix组件，实现了断路器模式，SpringCloud对这一组件进行了整合。 
在微服务架构中，一个请求需要调用多个服务是非常常见的，如下图：

![Image text](https://github.com/guangyaowu/SpringCloud/blob/master/img-storage/HystrixGraph.png)

较底层的服务如果出现故障，会导致连锁故障。当对特定的服务的调用的不可用达到一个阀值（Hystric 是5秒20次） 断路器将会被打开。

![Image text](https://github.com/guangyaowu/SpringCloud/blob/master/img-storage/HystrixFallback.png)

断路打开后，可用避免连锁故障，fallback方法可以直接返回一个固定值。

