package com.ym.dubbo.impl;

import com.ym.dubbo.api.TestInterface;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Service(group = "271")
@Component
public class TestImpl implements TestInterface {

    @Override
    public String getName(String name) {
        return "sss";
    }
}
