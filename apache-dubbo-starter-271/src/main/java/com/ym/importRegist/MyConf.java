package com.ym.importRegist;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@MyScan(value = "com.ym.importRegist")
//@ComponentScan("com.ym.importRegist")
public class MyConf {

    public void say(){
        System.out.println("this myconfig");
    }

}
