package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/4/29 15:33
 * @Description
 *      如果ribbon使用的是默认提供的负载均衡算法，则可以不使用ribbon的注解
 *      如果需要自定义的负载均衡算法的时候必须要使用ribbon @RibbonClient注解
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRun6082 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6082.class, args);
    }

}
