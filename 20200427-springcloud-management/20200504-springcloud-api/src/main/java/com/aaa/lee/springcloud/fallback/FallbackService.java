package com.aaa.lee.springcloud.fallback;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.IBookService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/4 15:54
 * @Description
 *      FallbackFactory是一个统一熔断处理工厂
 *          需要告诉该工厂要处理哪一个类的熔断(无论是consumer去调用api还是api调用provider)
 *          最终所有的调用都和api相关
 *          熔断完API之后就必须要重写api接口中的所有方法
 *
 *      在springcloud2.x中，hystrix做了一个非常大非常大的改动
 *          无论consumer中有多少controller，api中的接口只能有一个！！
 *          最终api接口中的命名要规则，不能再具体的命名了(一般情况下是以项目名命名)
 *          ISpringCloudService
 *          但是不能再写成IBookService,IUserSerivce,IOrderSerivce...
 *          容易造成误导！！
 *
 *      记住：
 *          一个常规方法就必须要有一个后备方法，而且是只能有一个
 *
 **/
@Component
public class FallbackService implements FallbackFactory<IBookService> {

    @Override
    public IBookService create(Throwable throwable) {
        IBookService bookService = new IBookService() {
            @Override
            public List<Book> selectAllBooks() {
                System.out.println("目前服务器正在处于降级阶段，请等待恢复通知！！");
                return null;
            }
        };
        return bookService;
    }
}
