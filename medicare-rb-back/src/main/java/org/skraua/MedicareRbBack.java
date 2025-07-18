package org.skraua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.skraua.mapper")
public class MedicareRbBack {
    public static void main(String[] args) {
        System.out.println("MedicareRbBack is starting...");
        SpringApplication.run(MedicareRbBack.class, args);
    }
}
