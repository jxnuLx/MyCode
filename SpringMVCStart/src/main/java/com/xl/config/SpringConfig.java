package com.xl.config;


import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@Configuration
//@ComponentScan({"com.xl.dao","com.xl.service"})
@PropertySource({"classpath:jdbc.properties"})  //加载配置文件，但是不支持使用通配符*.properties,一定要加这个classpath，不然会报错
@Import({JdbcConfig.class,MybatisConfig.class})  //导入其他的配置类
@ComponentScan(value = "com.xl.service",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Controller.class
        ))
@EnableTransactionManagement  //开启事务的三步骤 1.第一步开启注解式事务驱动
public class SpringConfig {
}
