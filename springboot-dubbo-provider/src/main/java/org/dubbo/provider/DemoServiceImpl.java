package org.dubbo.provider;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.dubbo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模拟 消息生产者
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendHello() {
        // 向Proder发送消息                              topic           发送的消息
        rocketMQTemplate.convertAndSend("topic_001", "Hello RocketMQ");

    }
}