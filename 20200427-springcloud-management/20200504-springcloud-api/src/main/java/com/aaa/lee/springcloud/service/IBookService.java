package com.aaa.lee.springcloud.service;

import com.aaa.lee.springcloud.fallback.FallbackService;
import com.aaa.lee.springcloud.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/4 14:41
 * @Description
 *
 **/
@FeignClient(value = "book-provider", fallbackFactory = FallbackService.class)
// @FeignClient(value = "book-provider")
public interface IBookService {

    /**
     * @author Seven Lee
     * @description
     *      这个方法就是通过consumer来调用provider的方法
     *      如果抛出异常一定和这个方法相关
     *      因为consumer中有这个方法
     *      provider中也必须有这个方法
     * @param []
     * @date 2020/5/4
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/all")
    List<Book> selectAllBooks();

}