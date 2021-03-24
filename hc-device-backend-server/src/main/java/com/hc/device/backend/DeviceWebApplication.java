package com.hc.device.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableTransactionManagement
@EnableFeignClients
@MapperScan("com.hc.device.dao")
@ComponentScan(basePackages = {"com.hc"},excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.vibe.*"))
@SpringBootApplication
public class DeviceWebApplication {
    public static void main( String[] args )
    {
    	SpringApplication.run(DeviceWebApplication.class,args);
    }
}
