package com.ldyswlp.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan("com.ldyswlp")
public class ServiceAuthApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceAuthApplication.class, args);
        log.info("项目启动成功");
    }
}
