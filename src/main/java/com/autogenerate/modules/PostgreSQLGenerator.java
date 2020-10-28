package com.autogenerate.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.autogenerate.abs.AbstractGenerator;
import com.baomidou.mybatisplus.annotation.DbType;

/**
 * PostgreSQL
 * 
 * @author xhx
 *
 */
public class PostgreSQLGenerator extends AbstractGenerator {

	private static String driverName = "org.postgresql.Driver";

	private static String dbUrlPrefix = "jdbc:postgresql://";

	public PostgreSQLGenerator(String dbUrl, String userName, String userPass, String outDir, String author) {
		super(driverName);
		this.setDbUrl(dbUrlPrefix + dbUrl);
		this.setUserName(userName);
		this.setUserPass(userPass);
		this.setOutDir(outDir);
		this.setAuthor(author);
		this.setDbType(DbType.POSTGRE_SQL);
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
