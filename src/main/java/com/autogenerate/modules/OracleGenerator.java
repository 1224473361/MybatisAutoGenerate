package com.autogenerate.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.autogenerate.abs.AbstractGenerator;
import com.baomidou.mybatisplus.annotation.DbType;

/**
 * oracle
 * 
 * @author xhx
 */
public class OracleGenerator extends AbstractGenerator {

	private static String driverName = "oracle.jdbc.OracleDriver";

	private static String dbUrlPrefix = "jdbc:oracle:thin:@";

	public OracleGenerator(String dbUrl, String userName, String userPass, String outDir, String author) {
		super(driverName);
		this.setDbUrl(dbUrlPrefix + dbUrl);
		this.setUserName(userName);
		this.setUserPass(userPass);
		this.setOutDir(outDir);
		this.setAuthor(author);
		this.setDbType(DbType.ORACLE);
	}

	/**
	 * @param tableNames
	 * @param packageName
	 */
	@Override
	public void generateCode(String[] tableNames, String packageName) {
		this.generateByTables(packageName, tableNames);
	}

	@Override
	public List<Map<String, String>> queryAllTableInfo() {
		return new ArrayList<>();
	}

}
