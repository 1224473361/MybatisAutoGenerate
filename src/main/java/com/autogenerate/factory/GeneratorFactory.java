package com.autogenerate.factory;

import com.autogenerate.abs.AbstractGenerator;
import com.autogenerate.modules.MySqlGenerator;
import com.autogenerate.modules.OracleGenerator;
import com.autogenerate.modules.PostgreSQLGenerator;

/**
 * 构建工厂
 * 
 * @author xhx
 *
 */
public class GeneratorFactory {

	/**
	 * 根据类型获取实例
	 * @param dbType
	 * @param dbUrl
	 * @param userName
	 * @param userPass
	 * @param outDir
	 * @param author
	 * @return
	 */
	public static AbstractGenerator init(String dbType, String dbUrl, String userName, String userPass, String outDir,
			String author) {
		switch (dbType.toLowerCase()) {
		case "mysql":
			return new MySqlGenerator(dbUrl, userName, userPass, outDir, author);
		case "oracle":
			return new OracleGenerator(dbUrl, userName, userPass, outDir, author);
		case "postgresql":
			return new PostgreSQLGenerator(dbUrl, userName, userPass, outDir, author);
		default:
			break;
		}
		throw new RuntimeException("类型异常");
	}

}
