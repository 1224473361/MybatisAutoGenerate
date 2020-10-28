package com.autogenerate.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.autogenerate.abs.AbstractGenerator;
import com.baomidou.mybatisplus.annotation.DbType;

/**
 * mysql
 * 
 * @author xhx
 *
 */
public class MySqlGenerator extends AbstractGenerator {

	private static String driverName = "com.mysql.cj.jdbc.Driver";

	private static String dbUrlPrefix = "jdbc:mysql://";

	public MySqlGenerator(String dbUrl, String userName, String userPass, String outDir, String author) {
		super(driverName);
		this.setDbUrl(dbUrlPrefix + dbUrl);
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
		this.generateByTables(packageName, tableNames);
	}

	@Override
	public List<Map<String, String>> queryAllTableInfo() {
		List<Map<String, String>> list = new ArrayList<>();
		if (StringUtils.isEmpty(getDbUrl()) || StringUtils.isEmpty(getUserName())
				|| StringUtils.isEmpty(getUserPass())) {
			return list;
		}
		executeSQL(
				"SELECT t.TABLE_NAME,t.TABLE_COMMENT FROM information_schema.`TABLES` t WHERE t.TABLE_SCHEMA = '' and t.TABLE_TYPE='BASE TABLE'");
		return list;
	}

	private void executeSQL(String sql) {
		
	}

}
