package com.ym.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ym.dubbo.api.TestInterface;
import org.springframework.stereotype.Component;


@Service(group = "021")
@Component
public class TestImpl implements TestInterface {

    @Override
    public String getName(String name) {
        return "sss";
    }
}
