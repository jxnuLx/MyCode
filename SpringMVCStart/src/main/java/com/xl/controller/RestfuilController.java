package com.xl.controller;

import com.xl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class RestfuilController {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user) {
        System.out.println("user save ..." + user);
        return "{'module':'user save'}";
    }

    /**
     * 修改@RequestMapping的value属性，将其中修改为/users/{id}，目的是和路径匹配
     * 在方法的形参前添加@PathVariable注解
     * @param id
     * @return
     */

    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id){
        System.out.println("user delete ..." + id);
        return "{'module':'user delete'}";
    }
}
