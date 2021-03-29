package com.jzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:MainApp8401
 * Package:com.jzk.springcloud
 * Description:
 *
 * @Date:2021/3/28 11:12
 * @Author:JIANGZHIKUAN
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp8401 {

    public static void main(String[] args) {
        SpringApplication.run(MainApp8401.class,args);
    }

}
