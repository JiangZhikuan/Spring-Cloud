package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ConsumerController
 * Package:com.simple.controller
 * Description:
 *
 * @Date:2021/2/23 21:47
 * @Author:JZK
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/helloConsumer")
    public String helloConsumer(){
        return restTemplate.getForObject("http://HELLO-SERVICE/hello",String.class);
    }

}
