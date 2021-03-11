package com.jzk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * ClassName:ReceiveMessageListenerController
 * Package:com.jzk.springcloud.controller
 * Description:
 *
 * @Date:2021/3/11 21:38
 * @Author:JZK
 */
@Component
@EnableBinding({Sink.class})
@Slf4j
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号，------->接收消息:" + message.getPayload() + "  port:" + serverPort);
    }
}
