package org.dubbo.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消息 消费者
 */
@Component
// 指定topic 和 消费者组
@RocketMQMessageListener(topic = "topic_001", consumerGroup = "${rocketmq.producer.group}")
public class ConsumerMode implements RocketMQListener<String> { // 继承RocketMQListener接口


    @Override
    public void onMessage(String s) {
        System.out.println("收到的消息是："+s);
    }
}