package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/4/27 17:02
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @author Seven Lee
     * @description
     *      查询所有的图书信息(服务的消费者)
     *      getForObject():中两个参数
     *      第一个参数是String类型
     *          需要远程访问的项目地址
     *          localhost:8081/all
     *      第二个参数Class类型
     *          所要接收的返回值类型
     * @param []
     * @date 2020/4/27
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/bookAll")
    public List<Book> selectAllBooks() {
        return restTemplate.getForObject("http://localhost:8081/all", List.class);
    }
}
