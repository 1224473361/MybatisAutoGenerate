package com.autogenerate.modules;

import com.autogenerate.abs.AbstractGenerator;
import com.baomidou.mybatisplus.annotation.DbType;

/**
 * 
 * @author 12244
 * @date 2020年4月28日
 *
 */
public class MySqlGenerator extends AbstractGenerator {

	private static String driverName = "com.mysql.jdbc.Driver";

	// jdbc:mysql://ip:port/hnyw
	private static String dbUrlPrefix = "jdbc:mysql://";

	public MySqlGenerator(String dbUrl, String userName, String userPass, String outDir, String author) {
		super(driverName);
		this.setDbUrl(dbUrl);
		this.setUserName(userName);
		this.setUserPass(userPass);
		this.setOutDir(outDir);
		this.setAuthor(author);
		this.setDbType(DbType.MYSQL);
	}

	/**
	 * @param tableNames
	 * @param packageName
	 */
	@Override
	public void generateCode(String[] tableNames, String packageName) {
		this.setDbUrl(dbUrlPrefix + this.getDbUrl());
		this.generateByTables(packageName, tableNames);
	}

}
