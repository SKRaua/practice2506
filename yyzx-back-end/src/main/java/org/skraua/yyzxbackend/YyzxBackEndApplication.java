package org.skraua.yyzxbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.skraua.yyzxbackend.mapper")
public class YyzxBackEndApplication {

    public static void main(String[] args) {
        System.out.println("YyzxBackEndApplication is starting...");
        SpringApplication.run(YyzxBackEndApplication.class, args);
    }

}
