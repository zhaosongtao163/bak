package com.stzhao.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter, Ordered {
	private static Logger log = LoggerFactory.getLogger(AuthFilter.class);

	

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("AuthFilterAuthFilterAuthFilter");
		log.info("===AuthFilter==" + exchange.getRequest().getURI().getRawPath());

		return chain.filter(exchange);

	}
	@Override
	public int getOrder() {
		return -10000000;
	}
}
