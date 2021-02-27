package com.jzk.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName:OrderConsulController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/2/27 10:50
 * @Author:JZK
 */
@RestController
public class OrderConsulController {

    public static final String PAYMENT_URL = "http://cloud-privider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return result;
    }

}
