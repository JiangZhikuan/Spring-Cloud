package com.jzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName:EurekaMain7001
 * Package:com.jzk.springcloud
 * Description:
 *
 * @Date:2021/2/25 12:40
 * @Author:JIANGZHIKUAN
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }

}
