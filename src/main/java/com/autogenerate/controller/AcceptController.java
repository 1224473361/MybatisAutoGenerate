package com.autogenerate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.autogenerate.modules.OracleGenerator;

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
			String packageName, String tableNames) {
		List<String> list = JSONArray.parseArray(tableNames, String.class);
		String[] strings = new String[list.size()];
		list.toArray(strings);

		try {
			OracleGenerator oracleGenerator = new OracleGenerator(dbUrl, userName, userPass, outDir, author);
			oracleGenerator.generateCode(strings, packageName);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "0";
		}
		return "1";
	}

}
