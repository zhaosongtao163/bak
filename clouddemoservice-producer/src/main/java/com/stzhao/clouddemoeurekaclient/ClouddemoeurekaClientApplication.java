package com.stzhao.clouddemoeurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.stzhao.*")
@EnableDiscoveryClient
public class ClouddemoeurekaClientApplication {

	//port=9100
	public static void main(String[] args) {
		SpringApplication.run(ClouddemoeurekaClientApplication.class, args);
	}

}
