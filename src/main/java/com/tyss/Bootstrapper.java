package com.tyss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplication注解代替了@Configuration、@EnableAutoConfiguration、@ComponentScan 注解
//@Configuration是一个类级注释，指示对象是一个bean定义的源
//@EnableAutoConfiguration启用自动配置
// @ComponentScan 为 @Configuration注解的类配置组件扫描指令
@SpringBootApplication
public class Bootstrapper {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrapper.class, args);
    }
}
