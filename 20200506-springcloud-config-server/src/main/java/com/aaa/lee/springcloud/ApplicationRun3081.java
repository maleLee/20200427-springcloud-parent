package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/6 14:54
 * @Description
 **/
@SpringBootApplication
@EnableConfigServer
public class ApplicationRun3081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun3081.class, args);
    }

}
