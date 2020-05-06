package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/4 15:16
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
     *      会故意抛出异常，直接进入方法中就会抛异常！
     *          必须要让正确的方法知道的后备方法是哪一个
     *          @HystrixCommand(fallbackMethod = "")
     *              fallbackMethod的值指向的是其实就是后备方法的方法名
     * @param []
     * @date 2020/5/4
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/all")
    //@HystrixCommand(fallbackMethod = "selectAllBooksFallbacl")
    public List<Book> selectAllBooks() throws Exception {
        List<Book> bookList = bookService.selectAllBooks();
        /*if(bookList.size() > 0) {
            // 说明数据库中有值，说明程序是对的(按照咱们目前的情况，一定会进if中)
            // 所以直接抛出异常
            throw new Exception("故意抛出异常");// 必会抛出异常
        }*/
        return bookList;
    }

    /*public List<Book> selectAllBooksFallbacl() {
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book();
        book.setId(100000L);
        book.setBookName("测试异常熔断");
        bookList.add(book);
        return bookList;
    }*/

}
