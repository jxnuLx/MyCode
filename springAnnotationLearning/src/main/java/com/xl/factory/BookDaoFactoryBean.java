package com.xl.factory;

import com.xl.dao.BookDao;
import com.xl.dao.impl.BookDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {
    //代替原始实例工厂中创建对象的方法
    @Override
    public BookDao getObject() throws Exception {
        return new BookDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }

    //true代表单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
