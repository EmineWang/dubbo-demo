package com.ym.importRegist;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by yanming on 2021/5/26.
 *
 * @Date 2021/5/26 19:02
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyAutoConfiguredMyBatisRegistrar.class)
public @interface MyScan {

    String[] value();

}
