package com.itcast.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration // 启动spring自动配置
//@ComponentScan  //包扫描 ，扫描该类所在的包 以及子包
@SpringBootApplication // 相当于上面两个注解综合  + springbootconfiguration
public class TestApplication {
	public static void main(String[] args){
		SpringApplication.run(TestApplication.class,args);
	}
}
