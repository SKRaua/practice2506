package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/*
 * @author Zhou Xinyang
 */
@Configuration
@ComponentScan({ "org.example.dao", "org.example.aop" })
@PropertySource(value = "application.properties", encoding = "UTF-8")
@EnableAspectJAutoProxy(proxyTargetClass = true) // 开启AOP自动代理
public class SpringConfig {

}
