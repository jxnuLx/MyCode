package com.xl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * @Configuration注解就代表着applicationContext配置文件
 */
@Configuration
@ComponentScan({"com.xl"}) //加载扫描包
@EnableAspectJAutoProxy
//@PropertySource({"jdbc.properties"})  //加载配置文件，但是不支持使用通配符*.properties
public class SpringConfig {
}
