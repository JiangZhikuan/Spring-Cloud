package com.jzk.springcloud.controller;

import com.jzk.springcloud.entities.CommonResult;
import com.jzk.springcloud.entities.Payment;
import com.jzk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:PaymentController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/2/24 14:58
 * @Author:JIANGZHIKUAN
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功" + port, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果：" + payment + "****");
        if (payment != null) {
            return new CommonResult(200, "查询成功" + port, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        //获取所有服务
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info(element);
        }
        //获取所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(item -> {
            System.out.println(item.getServiceId()+"->"+item.getHost()+"-->"+item.getPort()+"-->"+item.getUri());
        });
        return this.discoveryClient;
    }
}