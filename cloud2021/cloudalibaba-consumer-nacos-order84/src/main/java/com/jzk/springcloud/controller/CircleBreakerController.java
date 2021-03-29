package com.jzk.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.jzk.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName:CricleBreakerController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/3/28 21:43
 * @Author:JIANGZHIKUAN
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-uri.nacos-user-service}")
    private String service_url;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource("fallback")
    public CommonResult fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(service_url + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }
}
