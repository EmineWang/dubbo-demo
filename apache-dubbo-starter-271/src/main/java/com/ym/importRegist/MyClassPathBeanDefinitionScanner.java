package com.ym.importRegist;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * 类 名: MyClassPathBeanDefinitionScanner
 * 描 述: 定义一个扫描器，指定需要扫描的标识
 *
 * @author: jiaYao
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    /**
     * @addIncludeFilter 将自定义的注解添加到扫描任务中
     * @addExcludeFilter 将带有自定义注解的类 ，不加载到容器中
     */
    protected void registerFilters () {
        /**
         *  TODO addIncludeFilter  满足任意includeFilters会被加载
         */
        addIncludeFilter(new AnnotationTypeFilter(MyService.class));
        /**
         *  TODO addExcludeFilter 同样的满足任意excludeFilters不会被加载
         */
        // addExcludeFilter(new AnnotationTypeFilter(MyService.class));
    }

    /**
     * 重写类扫描包路径加载器，调用父类受保护的扫描方法 doScan
     * @param basePackages
     * @return
     */
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}