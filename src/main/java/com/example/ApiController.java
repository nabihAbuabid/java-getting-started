package com.example;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Resource
public class ApiController {
    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    Sender sender;

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        try {
            Foo foo = new Foo();
            String user = "User" + System.currentTimeMillis();
            LOG.info("Say helo to " + user);
            foo.setName(user);
            foo.setDescription("Hello " + user);
            sender.send(foo);
            return "Hello " + user;
        } catch (Exception e) {
            String stackTrace = ExceptionUtils.getStackTrace(e);
            LOG.info("ERRRRRRRRRRRRRRRROR in hello api " + stackTrace);
            return stackTrace;
        }
    }

}
