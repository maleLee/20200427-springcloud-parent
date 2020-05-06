package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/4/27 16:57
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @author Seven Lee
     * @description
     *      查询所有的图书信息
     * @param []
     * @date 2020/4/27
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        System.out.println("8081");
        return bookService.selectAllBooks();
    }

}
