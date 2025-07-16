package com.xl.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //设置当前访问路径，使用@RequestMapping
    @RequestMapping("/save")
    //设置当前对象的返回值类型
    @ResponseBody
    public String save(@RequestParam("name") String name){
        System.out.println("user save ..." + name);
        return "{'module':'SpringMVC'}";
    }

    @RequestMapping("/jsonArrayParam")
    @ResponseBody
    public String jsonArrayParam(@RequestBody List<String> hobbies) {
        System.out.println("JSON数组参数传递hobbies --> " + hobbies);
        return "{'module':'json array param'}";
    }

    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date1,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2,
                            @DateTimeFormat(pattern ="yyyy/MM/dd HH:mm:ss") Date date3) {
        System.out.println("参数传递date1 --> " + date1);
        System.out.println("参数传递date2 --> " + date2);
        System.out.println("参数传递date3 --> " + date3);
        return "{'module':'date param'}";
    }
}
