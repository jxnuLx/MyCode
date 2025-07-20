package com.xl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * 可以写简化的配置，implements WbeMVCConfigurer
 * 然后实现方法
 *     @Override
 *     protected void addInterceptors(InterceptorRegistry registry) {
 *         //配置拦截器,拦截路径是/books，只会拦截/books，拦截不到/books/1
 *         registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");  //注意只有http://localhost/books才能被拦截，http://localhost/books/1不能被拦截,加了"/books/*"后才能被拦截
 *     }
 *    这样的话就不需要加载SpringMvcSupport的拦截器了
 */
//@Configuration
@ComponentScan({"com.xl.controller","com.xl.config"})
@EnableWebMvc //开启json数据格式转化为对象
public class SpringMvcConfig {
}
