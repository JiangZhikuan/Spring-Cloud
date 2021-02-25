package com.jzk.springcloud.service.Impl;

import com.jzk.springcloud.dao.PaymentMapper;
import com.jzk.springcloud.entities.Payment;
import com.jzk.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:PaymentServiceImpl
 * Package:com.jzk.springcloud.service.Impl
 * Description:
 *
 * @Date:2021/2/24 14:56
 * @Author:JIANGZHIKUAN
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
