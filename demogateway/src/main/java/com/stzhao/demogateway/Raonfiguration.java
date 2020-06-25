package com.stzhao.demogateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class Raonfiguration {
	/**
	 * 按照Path限流
	 *
	 * @return key
	 */
	@Bean
	public KeyResolver pathKeyResolver() {
		System.out.println("---------pathKeyResolver---------");
		return exchange -> Mono.just(exchange.getRequest().getPath().toString());
	}
	
//	@Bean
//	public KeyResolver userKeyResolver() {
//		System.out.println("---------userKeyResolver---------");
//	    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
//	}
//	
//	@Bean
//	public KeyResolver ipKeyResolver() {
//	  return exchange -> Mono.just(
//	    exchange.getRequest()
//	    .getHeaders()
//	    .getFirst("X-Forwarded-For")
//	  );
//	}

	
	
	
}
