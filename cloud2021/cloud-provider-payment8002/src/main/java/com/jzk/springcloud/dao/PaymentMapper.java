package com.jzk.springcloud.dao;

import com.jzk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:PaymentDao
 * Package:com.jzk.springcloud.dao
 * Description:
 *
 * @Date:2021/2/24 14:48
 * @Author:JIANGZHIKUAN
 */

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
