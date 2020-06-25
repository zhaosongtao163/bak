//package com.stzhao.filter;
//
//import java.time.Duration;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.core.Ordered;
//import org.springframework.web.server.ServerWebExchange;
//
//import reactor.core.publisher.Mono;
//
//public class RateLimitByIpGatewayFilter implements GatewayFilter, Ordered {
//	int capacity;
//	int refillTokens;
//	Duration refillDuration;
//
//	private static final Map<String,Bucket> CACHE = new ConcurrentHashMap<>();
//
//    private Bucket createNewBucket() {
//        Refill refill = Refill.of(refillTokens, refillDuration);
//        Bandwidth limit = Bandwidth.classic(capacity, refill);
//        return Bucket4j.builder().addLimit(limit).build();
//    }
//
//	public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
//        // if (!enableRateLimit){
//        //     return chain.filter(exchange);
//        // }
//        String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
//        Bucket bucket = CACHE.computeIfAbsent(ip,k -> createNewBucket());
//
//        log.debug("IP: " + ip + "，TokenBucket Available Tokens: " + bucket.getAvailableTokens());
//        if (bucket.tryConsume(1)) {
//            return chain.filter(exchange);
//        } else {
//            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
//            return exchange.getResponse().setComplete();
//        }
//    }
//
//	public int getOrder() {
//		return -1000;
//	}
//}
