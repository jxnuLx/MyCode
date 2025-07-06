package com.xl.factory;

import com.xl.dao.BookDao;
import com.xl.dao.impl.BookDaoImpl;

public class BookDaoFactory {
    public static BookDao getBookDaoImpl(){
        return new BookDaoImpl();
    }
}
