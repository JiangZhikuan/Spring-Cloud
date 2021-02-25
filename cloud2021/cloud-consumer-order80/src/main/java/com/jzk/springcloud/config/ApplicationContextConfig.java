package com.jzk.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ApplicationContextConfig
 * Package:org.jzk.springcloud.config
 * Description:
 *
 * @Date:2021/2/24 21:41
 * @Author:JZK
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
