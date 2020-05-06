package com.aaa.lee.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/6 15:43
 * @Description
 **/
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @GetMapping("/test")
    public String test() {
        return port+"--------------"+driverClassName;
    }

}
