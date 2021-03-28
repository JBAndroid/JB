package com.jiangbo.router.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称：
 * 类描述：
 *
 * @auther jiangbo
 * 创建时间：2021-03-28
 */

/**
 * Target 元注解，当前注解 修饰的元素 为 类
 * Retention 注解 保存的时间  当前的注解的生命周期， SOURCE == .Java文件保留
 * CLASS === 当 .java 编译成Class 是保留的
 * RUNTime 生命周期 是最长的
 */

@Target({ElementType.TYPE})

@Retention(RetentionPolicy.CLASS)
public @interface Destination {

    // 指定的 当前页面的url  不能为null
    String url();

    /**
     * 页面描述
     *
     * @return
     */
    String description() default "";
}
