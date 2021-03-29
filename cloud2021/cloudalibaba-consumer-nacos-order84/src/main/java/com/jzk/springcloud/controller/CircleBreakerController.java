package com.jzk.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jzk.springcloud.entities.CommonResult;
import com.jzk.springcloud.entities.Payment;
import com.jzk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName:CricleBreakerController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/3/28 21:43
 * @Author:JIANGZHIKUAN
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-uri.nacos-user-service}")
    private String service_url;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;


    //    openFeign
    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }


    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource("fallback")
//    @SentinelResource(value = "fallback", fallback = "handleFallBack")  //fallback 只处理异常兜底方法
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")   // sentinel限流处理方法
    @SentinelResource(value = "fallback", fallback = "handleFallBack", blockHandler = "blockHandler", exceptionsToIgnore = IllegalArgumentException.class)

    public CommonResult fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(service_url + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult handleFallBack(@PathVariable Long id, Throwable throwable) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常处理方法handleFallBack--->" + throwable.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException throwable) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "sentinel限流处理方法blockHandler--->" + throwable.getMessage(), payment);
    }
}
