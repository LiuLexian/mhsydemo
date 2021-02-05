package com.mh.mhsy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mh.*.mapper")
public class MhsyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MhsyApplication.class, args);
    }

}
