package com.jzk.springcloud.service;

import com.jzk.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * InterfaceName:PaymentService
 * Package:com.jzk.springcloud.service
 * Description:
 *
 * @Date:2021/3/29 13:14
 * @Author:JIANGZHIKUAN
 */
@FeignClient(value = "nacos-payment-provider" ,fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id);

}
