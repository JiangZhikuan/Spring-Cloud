package com.jzk.springcloud.controller;

import com.jzk.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName:OrderZKController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/2/26 13:24
 * @Author:JIANGZHIKUAN
 */
@RestController
public class OrderZKController {

    public static final String PAYMENT_URL = "http://cloud-privider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
        return result;
    }

}
