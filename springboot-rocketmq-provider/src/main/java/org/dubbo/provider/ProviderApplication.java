package org.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        // 获取上下文
        ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);
        // 模拟Controller调用这个接口（启动后直接调用sendHello()方法，发送消息）
        DemoServiceImpl demoService = (DemoServiceImpl) context.getBean("demoService");
        demoService.sendHello();
    }
}