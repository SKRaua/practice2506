package org.skraua.yyzxbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Zhou Xinyang
 * @date 2025/06/19
 * @description Web配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 全局配置，如拦截器、视图解析器等

    // 添加拦截器配置
    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        // 解决跨域问题
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    // 解决日期格式问题
    @Override
    public void addFormatters(@NonNull FormatterRegistry registry) {
        // 添加自定义的日期格式化器
        WebMvcConfigurer.super.addFormatters(registry);
    }
}

// 自定义视图解析器配置
