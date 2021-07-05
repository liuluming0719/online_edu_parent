package com.llm.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: Edu启动类
 * @author: LiuLuMing
 * @createtime: 2021-06-26 22:12
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.llm"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
