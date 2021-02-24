package com.simple.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:HelloController
 * Package:com.simple.controller
 * Description:
 *
 * @Date:2021/2/23 21:02
 * @Author:JZK
 */
@RestController
public class HelloController {

    private final Logger logger= LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {

        logger.info(String.valueOf(System.currentTimeMillis()));
        return "hello";
    }

}
