package com.ym.importRegist;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 类 名: MyAutoConfiguredMyBatisRegistrar
 * 描 述: 测试动态注入Bean到Spring容器中
 */
public class MyAutoConfiguredMyBatisRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     * 动态置顶扫描包路径下特殊的类加载到Bean中
     *
     * @param importingClassMetadata
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {


        Set<String> packages = getPackagesToScan(importingClassMetadata);
        System.out.println("解析注解得到packages==>" + packages);

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ServicePostProcessor.class);
        beanDefinitionBuilder.addConstructorArgValue(packages);

//        BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
//        String name = beanNameGenerator.generateBeanName(beanDefinitionBuilder.getBeanDefinition(), registry);// 这种方式获得的name是servicePostProcessor
//        registry.registerBeanDefinition(name,beanDefinitionBuilder.getBeanDefinition());


        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);// 这种方式获得name是默认的com.ym.importRegist.ServicePostProcessor#0

    }

    private Set<String> getPackagesToScan(AnnotationMetadata metadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                metadata.getAnnotationAttributes(MyScan.class.getName()));
        String[] value = attributes.getStringArray("value");
        Set<String> packagesToScan = new LinkedHashSet<String>(Arrays.asList(value));
        return packagesToScan;
    }
}