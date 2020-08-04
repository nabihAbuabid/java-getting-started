package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
    @Autowired
    Sender sender;

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        Foo foo = new Foo();
        String user = "User" + System.currentTimeMillis();
        foo.setName(user);
        foo.setDescription("Hello " + user);
        sender.send(foo);
        return "Hello " + user;
    }

}
