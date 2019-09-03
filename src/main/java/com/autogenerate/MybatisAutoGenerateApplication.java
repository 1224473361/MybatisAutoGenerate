package com.autogenerate;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import lombok.extern.slf4j.Slf4j;

/**
 * 入口
 * 
 * @date 2019年9月3日
 * @author lihui
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@Slf4j
public class MybatisAutoGenerateApplication {

	private static String url = "http://localhost/index.html";

	public static void main(String[] args) {
		SpringApplication.run(MybatisAutoGenerateApplication.class, args);

		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

}
