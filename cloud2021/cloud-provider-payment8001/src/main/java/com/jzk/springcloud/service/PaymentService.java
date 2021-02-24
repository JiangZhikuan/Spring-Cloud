package com.jzk.springcloud.service;

import com.jzk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * InterfaceName:PaymentService
 * Package:com.jzk.springcloud.service
 * Description:
 *
 * @Date:2021/2/24 14:55
 * @Author:JIANGZHIKUAN
 */

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
