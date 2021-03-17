package com.jzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:NacosConfigMain3377
 * Package:com.jzk.springcloud
 * Description:
 *
 * @Date:2021/3/17 20:00
 * @Author:JZK
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain3377.class, args);
    }

}
