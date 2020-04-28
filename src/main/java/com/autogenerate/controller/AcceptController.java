package com.autogenerate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.autogenerate.abs.AbstractGenerator;
import com.autogenerate.factory.GeneratorFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @date 2019年9月3日
 * @author lihui
 */
@RestController
@Slf4j
public class AcceptController {

	@RequestMapping("/doGenerate")
	public String doGenerate(String dbUrl, String userName, String userPass, String outDir, String author,
			String packageName, String tableNames, String dbType) {
		List<String> list = JSONArray.parseArray(tableNames, String.class);
		String[] strings = new String[list.size()];
		list.toArray(strings);

		try {
			AbstractGenerator generator = GeneratorFactory.init(dbType, dbUrl, userName, userPass, outDir, author);
			generator.generateCode(strings, packageName);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "0";
		}
		return "1";
	}

}
