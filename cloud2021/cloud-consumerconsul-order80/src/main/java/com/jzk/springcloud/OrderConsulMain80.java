package com.jzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:OrderConsulMain80
 * Package:com.jzk.springcloud
 * Description:
 *
 * @Date:2021/2/27 10:47
 * @Author:JZK
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {


    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }

}
