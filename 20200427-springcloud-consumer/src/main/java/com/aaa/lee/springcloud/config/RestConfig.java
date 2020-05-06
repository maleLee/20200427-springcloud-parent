package com.aaa.lee.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/4/27 17:03
 * @Description
 *      springcloud这个架构给咱们提供的模拟http协议的工具类不叫HttpClient
 **/
@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
