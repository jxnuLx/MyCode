package com.xl.controller;

import com.xl.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RestFulSimple {
    @PostMapping
    public String save(@RequestBody User user) {
        System.out.println("user save ..." + user);
        return "{'module':'user save'}";
    }

    @DeleteMapping("/{id}/{name}")
    public String delete(@PathVariable("id") Integer userId, @PathVariable String name) {
        System.out.println("user delete ..." + userId + ":" + name);
        return "{'module':'user delete'}";
    }

    @PutMapping()
    public String update(@RequestBody User user) {
        System.out.println("user update ..." + user);
        return "{'module':'user update'}";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("user getById ..." + id);
        return "{'module':'user getById'}";
    }

    @GetMapping
    public String getAll() {
        System.out.println("user getAll ...");
        return "{'module':'user getAll'}";
    }
}
