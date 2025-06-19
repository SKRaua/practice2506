package org.skraua.yyzxbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 这里可以添加一些全局的配置，比如拦截器、视图解析器等
    // 例如，如果需要添加一个拦截器，可以在这里进行配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 解决跨域问题
        WebMvcConfigurer.super.addInterceptors(registry);
    }


    // 解决日期格式问题
    @Override
    public void addFormatters(org.springframework.format.FormatterRegistry registry) {
        // 添加自定义的日期格式化器
        WebMvcConfigurer.super.addFormatters(registry);
    }
}

// 自定义视图解析器配置
