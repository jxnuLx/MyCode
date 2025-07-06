package com.xl.factory;

import com.xl.dao.BookDao;
import com.xl.dao.impl.BookDaoImpl;

public class BookDaoFactory1 {
    //唯一的区别就是去掉的static
    public BookDao getBookDaoImpl() {
        System.out.println("book dao factory setup ...");//模拟必要的业务操作
        //这里还可以加一大堆业务逻辑
        return new BookDaoImpl();
    }
}
