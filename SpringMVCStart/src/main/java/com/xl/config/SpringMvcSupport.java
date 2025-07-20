package com.xl.config;

import com.xl.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * springmvc核心就是一个servlet做请求分发，filter是在进入servlet之前，filter属于servlet技术，interceptor是在进入servlet之后
 * ，interceptor属于MVC技术，filter对所有的访问进行增强，但是interceptor仅仅针对SpringMVC的访问进行增强，
 */

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Autowired
    private ProjectInterceptor projectInterceptor;

    //设置静态资源访问过滤，当前类需要设置为配置类，并被扫描加载
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages/xxx时候，从/pages目录下查找内容
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }


    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器,拦截路径是/books，只会拦截/books，拦截不到/books/1
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");  //注意只有http://localhost/books才能被拦截，http://localhost/books/1不能被拦截,加了"/books/*"后才能被拦截
    }
}
