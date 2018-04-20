# SpringCloud 学习项目


spring cloud 为开发人员提供了快速构建分布式系统的一些工具，
包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等。
它运行环境简单，可以在开发人员的电脑上跑。
另外说明spring cloud是基于springboot的

在微服务架构中，需要几个基础的服务治理组件，包括服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，由这几个基础组件相互协作，共同组建了一个简单的微服务系统。<br>
一个简单的微服务系统如下图：<br>
![Image text](https://github.com/guangyaowu/SpringCloud/blob/master/img-storage/Azure.png)<br>
<font size="3" color="red">注意：A服务和B服务是可以相互调用的，作图的时候忘记了。并且配置服务也是注册到服务注册中心的。</font>

在Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过负载均衡（Ngnix），再到达服务网关（zuul集群），然后再到具体的服。，服务统一注册到高可用的服务注册中心集群，服务的所有的配置文件由配置服务管理，配置服务的配置文件放在git仓库，方便开发人员随时改配置。


<h2>Ribbon + RestTemplate</h2>

在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于http restful的。
Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。
ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon

ribbon 已经默认实现了这些配置bean：<br>
IClientConfig ribbonClientConfig: DefaultClientConfigImpl<br>
IRule ribbonRule: ZoneAvoidanceRule<br>
IPing ribbonPing: NoOpPing<br>
ServerList ribbonServerList: ConfigurationBasedServerList<br>
ServerListFilter ribbonServerListFilter: ZonePreferenceServerListFilter<br>
ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer


<h2>Feign</h2>

Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。<br>
使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。<br>
Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，<br>
默认实现了负载均衡的效果。<br>
简而言之：<br>
Feign 采用的是基于接口的注解<br>
Feign 整合了ribbon<br>


<h2>Hystrix</h2>

在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），<br>
在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。<br>
为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，<br>
如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，<br>
Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，<br>
会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。<br>
为了解决这个问题，业界提出了断路器模型。<br>
Netflix开源了Hystrix组件，实现了断路器模式，SpringCloud对这一组件进行了整合。 <br>
在微服务架构中，一个请求需要调用多个服务是非常常见的，如下图：<br>
![Image text](https://github.com/guangyaowu/SpringCloud/blob/master/img-storage/HystrixGraph.png)<br>
较底层的服务如果出现故障，会导致连锁故障。当对特定的服务的调用的不可用达到一个阀值（Hystric 是5秒20次） 断路器将会被打开。<br>
![Image text](https://github.com/guangyaowu/SpringCloud/blob/master/img-storage/HystrixFallback.png)<br>
断路打开后，可用避免连锁故障，fallback方法可以直接返回一个固定值。


<h2>Zuul</h2>

Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。
zuul有以下功能：<br>
Authentication<br>
Insights<br>
Stress Testing<br>
Canary Testing<br>
Dynamic Routing<br>
Service Migration<br>
Load Shedding<br>
Security<br>
Static Response handling<br>
Active/Active traffic management<br>

