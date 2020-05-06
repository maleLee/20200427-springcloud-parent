package com.aaa.lee.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/4 15:13
 * @Description
 *      @EnableCircuitBreaker:是springcloud2.x版本所支持的注解
 **/
@SpringBootApplication
@MapperScan("com.aaa.lee.springcloud.mapper")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationRun8084 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8084.class, args);
    }

}
