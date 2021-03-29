package com.jzk.springcloud.controller;

import com.jzk.springcloud.entities.CommonResult;
import com.jzk.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:PaymentController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/3/28 21:27
 * @Author:JIANGZHIKUAN
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "312312312312312"));
        hashMap.put(2L, new Payment(2L, "2f23f3fd3sf4ds34"));
        hashMap.put(3L, new Payment(3L, "0sds4434fs4fg543"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort" + serverPort, payment);
        return result;
    }

}