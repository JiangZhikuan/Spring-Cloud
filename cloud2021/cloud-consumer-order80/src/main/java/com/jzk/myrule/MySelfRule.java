package com.jzk.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:MySelfRule
 * Package:com.jzk.myrule
 * Description:
 *
 * @Date:2021/2/27 14:35
 * @Author:JZK
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
    }

}
