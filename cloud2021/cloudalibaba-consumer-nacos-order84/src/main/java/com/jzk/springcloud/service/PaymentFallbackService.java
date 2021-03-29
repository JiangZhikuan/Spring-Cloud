package com.jzk.springcloud.service;

import com.jzk.springcloud.entities.CommonResult;
import com.jzk.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * ClassName:PaymentFallbckService
 * Package:com.jzk.springcloud.service
 * Description:
 *
 * @Date:2021/3/29 13:18
 * @Author:JIANGZHIKUAN
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult(444,"服务降级返回--------->PaymentFallbackService",new Payment(id,"error"));
    }
}
