package com.jzk.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * ClassName:PaymentFallbackService
 * Package:com.jzk.springcloud.service
 * Description:
 *
 * @Date:2021/2/28 14:09
 * @Author:JIANGZHIKUAN
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fall back -paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fall back -paymentInfo_TimeOut";
    }
}
