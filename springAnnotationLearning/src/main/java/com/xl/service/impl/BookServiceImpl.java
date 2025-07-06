package com.xl.service.impl;

import com.xl.dao.BookDao;
import com.xl.dao.impl.BookDaoImpl;
import com.xl.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Spring给我们提供了两个接口来完成生命周期的控制，好处是可以不用再进行配置init-method和destroy-method
 */
@Service
public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    //5.删除业务层中使用new的方式创建的dao
//    private BookDao bookDao=new BookDaoImpl();
    @Autowired
    @Qualifier("bookDao")  //这个注解必须配合上面注解一起使用，用来加载指定名称的bean
    private BookDao bookDao;
    @Override
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    public void setBookDao(BookDaoImpl bookDao) {
        this.bookDao = bookDao;
        System.out.println("set方法被调用啦");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy ... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init ... ");
    }
}
