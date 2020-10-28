package com.autogenerate;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import lombok.extern.slf4j.Slf4j;

/**
 * 启动类
 * 
 * @author xhx
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@Slf4j
public class MybatisAutoGenerateApplication {

	private static String url = "http://localhost:801/index.html";

	public static void main(String[] args) {
		SpringApplication.run(MybatisAutoGenerateApplication.class, args);
		try {
			// 自动弹出操作网页
			String osName = System.getProperty("os.name");
			if (osName != null) {
				if (osName.contains("Mac")) {
					// 暂不支持
				} else if (osName.contains("Windows")) {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				}
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

}
