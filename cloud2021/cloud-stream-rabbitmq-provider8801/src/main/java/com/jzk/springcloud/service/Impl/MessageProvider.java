package com.jzk.springcloud.service.Impl;

import com.jzk.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ClassName:MessageProvider
 * Package:com.jzk.springcloud.service.Impl
 * Description:
 *
 * @Date:2021/3/11 21:12
 * @Author:JZK
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProvider implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("********serial:"+serial);
        return null;
    }
}
