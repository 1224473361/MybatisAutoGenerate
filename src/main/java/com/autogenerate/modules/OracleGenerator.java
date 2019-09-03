package com.autogenerate.modules;

import com.autogenerate.abs.AbstractGenerator;

/**
 * 
 * @date 2019年9月3日
 * @author lihui
 */
public class OracleGenerator extends AbstractGenerator {

	private static String driverName = "oracle.jdbc.OracleDriver";

	private static String dbUrlPrefix = "jdbc:oracle:thin:@";

	public OracleGenerator(String dbUrl, String userName, String userPass, String outDir, String author) {
		super(driverName);
		this.setDbUrl(dbUrl);
		this.setUserName(userName);
		this.setUserPass(userPass);
		this.setOutDir(outDir);
		this.setAuthor(author);
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
