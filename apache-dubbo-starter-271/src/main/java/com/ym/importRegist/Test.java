package com.ym.importRegist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yanming on 2021/5/26.
 *
 * @Date 2021/5/26 18:24
 */
public class Test {
    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConf.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println("beanDefinitionName ===> "+beanDefinitionNames[i]);
        }

        MyConf myConf = (MyConf)context.getBean("myConf");
        myConf.say();

        ServicePostProcessor servicePostProcessor = (ServicePostProcessor)context.getBean(ServicePostProcessor.class);
        System.out.println(servicePostProcessor.packages);
//        servicePostProcessor.hashCode();

        Test02 test02 = (Test02)context.getBean(Test02.class);
        test02.say();

//        System.out.println(context.getBean("myConf").hashCode());
//        System.out.println(context.getBean("servicePostProcessor").hashCode());
//        System.out.println(context.getBean("test02").hashCode());
    }
}
