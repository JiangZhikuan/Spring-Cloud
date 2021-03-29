package com.jzk.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jzk.springcloud.entities.CommonResult;
import com.jzk.springcloud.entities.Payment;

/**
 * ClassName:CustomerBlockHandler
 * Package:com.jzk.springcloud.handler
 * Description:
 *
 * @Date:2021/3/28 20:30
 * @Author:JIANGZHIKUAN
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException ex){
        return new CommonResult(444, "按Global自定义限流测试ok------1");
    }

    public static CommonResult handlerException2(BlockException ex){
        return new CommonResult(444, "按Global自定义限流测试ok------2");
    }

}
