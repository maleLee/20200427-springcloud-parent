package com.aaa.lee.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/4/29 15:43
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/")
    public List<Book> selectAllBooks() {
        // return restTemplate.getForObject("http://localhost:8081/all", List.class);
        return restTemplate.getForObject("http://BOOK-PROVIDER/all", List.class);
    }

    /**
     * @author Seven Lee
     * @description
     *      ribbon脱离eureka实现负载均衡
     *      访问的时候报错:
     *          No instances available for localhost
     *          已经可以访问到这个信息了，但是会报错
     *          在ribbon脱离eureka实现负载均衡的时候必须要求使用正式环境(上线环境)
     *          也就是说必须要有外网ip(公网ip)(不能使用localhost)
     *          可以使用花生壳来进行测试(收费)-->内网穿透
     * @param []
     * @date 2020/4/29
     * @return java.util.List<java.awt.print.Book>
     * @throws
    **/
    @GetMapping("/noEureka")
    public List<Book> selectAllBooksNoEureka() {
        // 1.根据在application.properties文件中所配置算法规则来选择出最终需要找到Server服务器信息
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-provider");
        // 2.Server对象中有provider服务器的ip地址以及端口号，获取选择出来的那一台provider的ip地址
        String host = serviceInstance.getHost();
        System.out.println(host);
        // 3.获取端口号
        int port = serviceInstance.getPort();
        System.out.println(port);
        return restTemplate.getForObject("http://"+host+":"+port+"/all", List.class);
    }

}
