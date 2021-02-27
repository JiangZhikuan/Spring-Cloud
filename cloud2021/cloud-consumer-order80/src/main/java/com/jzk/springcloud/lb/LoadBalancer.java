package com.jzk.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * interfaceName:LoadBalancer
 * Package:com.jzk.springcloud.lb
 * Description:
 *
 * @Date:2021/2/27 15:09
 * @Author:JZK
 */

public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
