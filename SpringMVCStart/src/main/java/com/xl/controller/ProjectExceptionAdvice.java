package com.xl.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        System.out.println("嘿嘿，逮到一个异常~");
        return new Result(666, null, "嘿嘿，逮到一个异常~");
    }
}
