package com.xl.dao.impl;

import com.xl.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }

    //表示bean初始化方法
    public void init() {
        System.out.println("init ... ");
    }

    //表示bean销毁方法
    public void destroy() {
        System.out.println("destroy ... ");
    }
}
