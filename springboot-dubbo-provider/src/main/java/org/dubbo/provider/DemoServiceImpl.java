package org.dubbo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.dubbo.DemoService;

@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}