package com.stzhao.demogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.stzhao.filter.AuthFilter;
import com.stzhao.filter.ElapsedFilter;

@SpringBootApplication
@EnableDiscoveryClient
public class DemogatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemogatewayApplication.class, args);
	}

	@Bean
	public AuthFilter tokenFilter() {
		return new AuthFilter();
	}
	@Bean
    public RouteLocator elapsedFilter(RouteLocatorBuilder builer) {
        return builer.routes()
                .route(r -> r.path("/girl/**") // 匹配路径
                        .filters(
//                                f -> f.stripPrefix(1) // 剔除bar-service
//                                .filter(new BarFilter()) // 应用过滤器
                        		f ->f.filter(new ElapsedFilter())
                                 )
                        .uri("http://localhost:9100").id("elapsedFilter")
                ).build();
    }
	
	
	
	
//    routes:
//        - id: payment_route_1              #路由id，随便写，建议配合服务名
//    #      uri: http://SERVICE-PRODUCER      #一定要匹配提供服务的路由地址，自测可以用这个URI
//          uri: lb://SERVICE-PRODUCER  #由于要进行负载均衡，所以用服务名（来自下面 服务端操作 YML）
//          predicates:
//             - Path=/rate/**			#断言，路径想匹配的进行路由
//   #         - Header=token, cloud-gateway	#断言，请求头的key为token，value为cloud-gateway
	
	
//    filters:
//        - name: RequestRateLimiter
//          args:
//            key-Resolver: '#{@pathKeyResolver}'
//            redis-rate-limiter.replenishRate: 1
//            redis-rate-limiter.burstCapacity: 2
}
