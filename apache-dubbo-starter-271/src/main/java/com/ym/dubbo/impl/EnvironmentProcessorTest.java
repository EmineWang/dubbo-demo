package com.ym.dubbo.impl;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.*;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class EnvironmentProcessorTest implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        ConfigurableEnvironment environment1 = (ConfigurableEnvironment) environment;
        MutablePropertySources propertySources = environment1.getPropertySources();

        Iterator<PropertySource<?>> iterator = propertySources.iterator();

        while (iterator.hasNext()) {
            PropertySource<?> source = iterator.next();
            boolean flag = source instanceof EnumerablePropertySource;
            System.out.println("source.getName()==========>"+source.getName() +"flag  "+ flag);

            if (source instanceof EnumerablePropertySource) {
                for (String name : ((EnumerablePropertySource<?>) source).getPropertyNames()) {

                    if(name.startsWith("dubbo.application.")){
                        Object value = source.getProperty(name);
                        String subName = name.substring("dubbo.application.".length());
                        System.out.println("subName===》"+subName +"   value===> "+value);
                    }


                }
            }

        }
    }
}
