package com.xl.dao.impl;

import com.xl.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
@Scope("prototype")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }

    @PostConstruct
    //表示bean初始化方法 在构造方法之后
    public void init() {
        System.out.println("init ... ");
    }

    @PreDestroy
    //表示bean销毁方法
    public void destroy() {
        System.out.println("destroy ... ");
    }
}
