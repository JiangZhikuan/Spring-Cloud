package com.jzk.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:FeignConfig
 * Package:com.jzk.springcloud.config
 * Description:
 *
 * @Date:2021/2/27 16:42
 * @Author:JZK
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
