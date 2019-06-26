package com.atguigu.gmall.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmall.ums.mapper")
public class GmallUmsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallUmsServiceApplication.class, args);
    }

}
