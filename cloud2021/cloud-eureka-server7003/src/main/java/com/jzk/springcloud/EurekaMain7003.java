package com.jzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName:EurekaMain7003
 * Package:com.jzk.springcloud
 * Description:
 *
 * @Date:2021/2/25 13:36
 * @Author:JIANGZHIKUAN
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7003.class, args);
    }

}
