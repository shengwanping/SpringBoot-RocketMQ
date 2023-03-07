package org.dubbo.provider;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.dubbo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟 消息生产者
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendHello() {
//        // 1、同步消息：发送同步消息是指producer向 broker发送消息,执行API时同步等待,直到broker服务器返回发送结果;
//        SendResult sendResult = rocketMQTemplate.syncSend("topic_001", "Hello RocketMQ 同步消息");
//        System.out.println(sendResult);
//
//        // 2、异步消息：指producer向broker发送消息时异步执行，不会影响后面逻辑。而异步里面会调用一个回调方法，来处理消息发送成功或失败的逻辑
//        rocketMQTemplate.asyncSend("topic_001", "Hello RocketMQ 异步消息", new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                System.out.println("异步消息 发送成功！");
//            }
//
//            @Override
//            public void onException(Throwable throwable) {
//                System.out.println("异步消息 发送失败！");
//            }
//        });
//
//        // 3、单向消息：是指producer向 broker发送消息,执行API时直接返回，不等待broker 服务器的响应
//        rocketMQTemplate.sendOneWay("topic_001", "Hello RocketMQ 单项消息");

//        // 4、延迟消息
//        rocketMQTemplate.syncSend("topic_001", "延迟消费0秒");
//        rocketMQTemplate.syncSend("topic_001", MessageBuilder.withPayload("延迟消费1秒").build(), 3000,1);
//        rocketMQTemplate.syncSend("topic_001", MessageBuilder.withPayload("延迟消费5秒").build(), 3000, 2);

//        // 5、事务消息
//        rocketMQTemplate.sendMessageInTransaction("topic_001", MessageBuilder.withPayload("事务消息").build(), null);

//        // 6-1、消息过滤  tag过滤
//        rocketMQTemplate.convertAndSend("topic_001"+":"+"TAG1", MessageBuilder.withPayload("TAG1消息").build());
//        rocketMQTemplate.convertAndSend("topic_001"+":"+"TAG2", MessageBuilder.withPayload("TAG2消息").build());
//        rocketMQTemplate.convertAndSend("topic_001"+":"+"TAG3", MessageBuilder.withPayload("TAG3消息").build());

        // 6-2、消息过滤  sql过滤
        Message msg1 = MessageBuilder.withPayload("rocketmq过滤消息测试01").build();
        Map<String, Object> headers = new HashMap<>();
        headers.put("name", "xiao ming");
        headers.put("a", 2) ;
        rocketMQTemplate.convertAndSend("topic_001", msg1, headers);

        Message msg2 = MessageBuilder.withPayload("rocketmq过滤消息测试02").build();
        Map<String, Object> headers1 = new HashMap<>();
        headers1.put("name", "xiao hua");
        headers1.put("a", 7) ;
        rocketMQTemplate.convertAndSend("topic_001", msg2, headers1);

    }

}
