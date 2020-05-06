package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/4/28 14:38
 * @Description
 *      无论是springboot项目还是springcloud项目，只有三步:
 *          1.添加所需要的jar包
 *          2.编写配置文件
 *          3.集成自动装配注解
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7081.class, args);
    }

}
