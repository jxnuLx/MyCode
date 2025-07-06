package com.xl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Configuration注解就代表着applicationContext配置文件
 */
@Configuration
@ComponentScan({"com.xl"}) //加载扫描包
@PropertySource({"jdbc.properties"})  //加载配置文件，但是不支持使用通配符*.properties
@Import({JdbcConfig.class,MybatisConfig.class})  //导入其他的配置类
public class SpringConfig {
}
