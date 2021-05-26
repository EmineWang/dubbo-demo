package com.ym.importRegist;

import java.lang.annotation.*;

/**
 * Created by yanming on 2021/5/26.
 *
 * @Date 2021/5/26 18:21
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface MyService {
}
