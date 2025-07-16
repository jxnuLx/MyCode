package com.xl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xl.controller")
@EnableWebMvc //开启json数据格式转化为对象
public class SpringMvcConfig {
}
