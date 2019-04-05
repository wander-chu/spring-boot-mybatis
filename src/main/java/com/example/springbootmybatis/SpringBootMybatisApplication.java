package com.example.springbootmybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.springbootmybatis.mapper")
public class SpringBootMybatisApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(SpringBootMybatisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        logger.info("服务启动完成!");
    }
}