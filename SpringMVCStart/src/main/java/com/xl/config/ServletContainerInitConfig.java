package com.xl.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;


//web3.0规范之后，不用web.xml来做，用配置类来做
//定义一个servlet容器的配置类，在里面加载Spring的配置，继承AbstractDispatcherServletInitializer并重写其方法
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
    //加载SpringMvc容器配置
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMvcConfig.class);
        return context;
    }
    //设置哪些请求归SpringMvc处理
    protected String[] getServletMappings() {
        //所有请求都交由SpringMVC处理
        return new String[]{"/"};
    }

    //加载Spring容器配置
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        return context;
    }

    //乱码处理

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter =new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
