package com.ffd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//@MapperScan("com.ffd.api.mapper")
@EnableConfigServer
//@EnableScheduling
//@EnableBatchProcessing
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
