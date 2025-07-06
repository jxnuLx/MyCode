package com.xl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xl.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    /**
     * 在JdbcConfig类的方法上添加参数
     * 引用类型注入只需要为bean定义方法设置形参即可，容器会根据类型自动装配对象。
     * bookDao爆红线忽略，照样可以运行
     * @return
     */
    @Bean
    public DataSource dataSource(BookDao bookDao) {
        System.out.println("自动注入bean");
        System.out.println(bookDao);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
