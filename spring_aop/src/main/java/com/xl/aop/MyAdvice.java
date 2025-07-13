package com.xl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@Aspect
public class MyAdvice {

    //这个切入点没有配置，不会去读取
    @Pointcut("execution(void com.xl.dao.BookDao.save())")
    private void px(){}

    //定义切入点，这里如果写dao的实现类impl也是一样的效果
    @Pointcut("execution(void com.xl.dao.BookDao.update())")
    private void pt(){}

    //定义切入点，这里如果写dao的实现类impl也是一样的效果
    @Pointcut("execution(int com.xl.dao.BookDao.select())")
    private void pt1(){}

    //定义的共性功能
    @Before("pt()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();  //可以拿到原始方法传入的参数
        System.out.println(System.currentTimeMillis());
        System.out.println("before advice...");
    }

    @After("pt()")
    public void after(){
        System.out.println("after advice...");
    }

    @Around("pt()")
    public void around(ProceedingJoinPoint pjd) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用
        pjd.proceed();
        System.out.println("around after advice ...");
    }

    @Around("pt1()")
    public Object aroundSelect(ProceedingJoinPoint pjd) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用,obj为原始方法的返回值
        Object obj=pjd.proceed();
        System.out.println("around after advice ...");
        return 200;
    }

    @AfterReturning(value = "pt1()",returning = "ret")  //只有在方法正常运行完时才会执行，如果方法抛出异常则不运行，并且在After之前输出
    //这个注解还可以获取返回值,ret定义一个用来接受返回值的形参，并且告诉注解用哪个变量接收返回值,返回值装到形参,joinPoint参数必须放在第一个参数位置
    public void afterReturning(JoinPoint joinPoint,Object ret){
        System.out.println("afterReturning advice ..."+ret);
    }

    @AfterThrowing("pt1()")  //抛出异常才会执行
    public void afterThrowing(){
        System.out.println("afterThrowing advice ...");
    }

}
