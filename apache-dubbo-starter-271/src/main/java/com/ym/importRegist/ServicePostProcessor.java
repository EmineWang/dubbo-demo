package com.ym.importRegist;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import java.util.Set;

/**
 * Created by yanming on 2021/5/26.
 *
 * @Date 2021/5/26 18:54
 */
public class ServicePostProcessor implements BeanDefinitionRegistryPostProcessor , ResourceLoaderAware {

    private ResourceLoader resourceLoader;


    public Set<String> packages ;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        // 当前MyClassPathBeanDefinitionScanner已被修改为扫描带有指定注解的类
        MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner(beanDefinitionRegistry, false);
        scanner.setResourceLoader(resourceLoader);
        scanner.registerFilters();

        for(String ss : packages){
            System.out.println("扫描包==》"+ss);
            scanner.doScan(ss);
        }
    }

    public ServicePostProcessor(Set<String> packages) {
        this.packages = packages;

    }

    /**
     * 获取Spring中的一些元数据
     * @param resourceLoader
     */
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {







    }
}
