package com.xl.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    //定义切入点
    @Pointcut("execution(void com.xl.dao.BookDao.update())")
    private void pt(){}

    //定义的共性功能
    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }

}
