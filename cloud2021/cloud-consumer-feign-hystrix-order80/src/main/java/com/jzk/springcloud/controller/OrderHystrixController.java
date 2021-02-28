package com.jzk.springcloud.controller;

import com.jzk.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:OrderHyrixController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/2/28 12:50
 * @Author:JIANGZHIKUAN
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_Global_TimeOutHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id) {
//        int timeNumber = 5;
        int age = 10 / 0;
//        try {
//            // 暂停3秒钟
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id) {

        return "我是消费者80，对方支付系统繁忙";
    }

    //全局fallback
    public String paymentInfo_Global_TimeOutHandler() {

        return "我是消费者80，对方支付系统繁忙,method:paymentInfo_Global_TimeOutHandler";
    }

}
