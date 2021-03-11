package com.jzk.springcloud.controller;

import com.jzk.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:SendMessageController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/3/11 21:22
 * @Author:JZK
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
