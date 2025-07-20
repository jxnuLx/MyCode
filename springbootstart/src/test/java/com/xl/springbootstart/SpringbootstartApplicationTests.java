package com.xl.springbootstart;

import com.xl.dao.BookDao;
import com.xl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootstartApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book book = bookDao.getById(1);
        System.out.println(book);
    }

    /**
     * 要测试的话直接测试接口就行，不用配置其他注解
     */
//    @Test
//    void contextLoads() {
//    }

}
