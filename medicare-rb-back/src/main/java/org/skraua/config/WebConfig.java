package org.skraua.config;

import org.skraua.utils.DateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Zhou Xinyang
 * @date 2025/07/07
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

    // 全局跨域配置
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowedOriginPatterns("*") // 允许所有前端域名
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    // 解决日期格式问题
    @Override
    public void addFormatters(@NonNull FormatterRegistry registry) {
        // 添加自定义的日期格式化器
        registry.addConverter(new DateConverter());
    }
}

// 自定义视图解析器配置
