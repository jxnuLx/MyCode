package com.xl.service;

import com.xl.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional   //开启事务第三步 3.打开业务层事务接口
public interface BookService {
    /**
     * 保存
     * @param book
     * @return
     */
    boolean save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    boolean update(Book book);

    /**
     * 按id删除
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    Book getById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Book> getAll();
}