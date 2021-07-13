package com.virgonia.spring5.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 3:22
 */
@Configuration
@ComponentScan(basePackages = {"com.virgonia"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {



}
