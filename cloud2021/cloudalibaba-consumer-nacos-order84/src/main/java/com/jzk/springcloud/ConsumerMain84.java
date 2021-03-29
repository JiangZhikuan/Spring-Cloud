package com.jzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:ConsunerMain84
 * Package:com.jzk.springcloud
 * Description:
 *
 * @Date:2021/3/28 21:05
 * @Author:JIANGZHIKUAN
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain84 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain84.class,args);
    }

}
