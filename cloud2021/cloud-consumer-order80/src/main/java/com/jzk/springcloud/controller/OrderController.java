package com.jzk.springcloud.controller;

import com.jzk.springcloud.lb.LoadBalancer;
import com.jzk.springcloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import com.jzk.springcloud.entities.CommonResult;
import com.jzk.springcloud.entities.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:OrderController
 * Package:org.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/2/24 21:36
 * @Author:JZK
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/create2")
    public CommonResult create2(Payment payment) {
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(commonResultResponseEntity.getHeaders() + "-->" + commonResultResponseEntity.getStatusCode());
            return commonResultResponseEntity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (resultResponseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(resultResponseEntity.getHeaders() + "-->" + resultResponseEntity.getStatusCode());
            return resultResponseEntity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }


    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0) return null;
        ServiceInstance instance = loadBalancer.instances(instances);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(instance.getUri() + "/payment/lb", String.class);
        return responseEntity.getBody();
    }
}
