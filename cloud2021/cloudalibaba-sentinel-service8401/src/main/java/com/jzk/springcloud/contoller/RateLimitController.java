package com.jzk.springcloud.contoller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jzk.springcloud.entities.CommonResult;
import com.jzk.springcloud.entities.Payment;
import com.jzk.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:RateLimitController
 * Package:com.jzk.springcloud.contoller
 * Description:
 *
 * @Date:2021/3/28 20:07
 * @Author:JIANGZHIKUAN
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult baResource() {
        return new CommonResult(200, "按资源名称限流测试ok", new Payment(2021L, "Serial001"));
    }

    public CommonResult handleException(BlockException ex) {
        return new CommonResult(444, ex.getClass().getCanonicalName() + "服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult baUrl() {
        return new CommonResult(200, "按资源名称限流测试ok", new Payment(2021L, "Serial001"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按自定义限流测试ok", new Payment(2021L, "Serial001"));
    }

}
