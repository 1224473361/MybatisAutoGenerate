package com.autogenerate.abs;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 核心生成逻辑
 * 
 * @date 2019年9月3日
 * @author lihui
 */
public abstract class AbstractGenerator {

	/**
	 * 数据库连接字符串
	 */
	private String dbUrl;
	/**
	 * 数据库用户
	 */
	private String userName;
	/**
	 * 数据库密码
	 */
	private String userPass;
	/**
	 * 代码输出路径
	 */
	private String outDir;
	/**
	 * 
	 */
	private String driverName;
	/**
	 * 代码注释里面的作者
	 */
	private String author;

	public AbstractGenerator(String driverName) {
		super();
		this.driverName = driverName;
	}

	/**
	 * 生成代码
	 * 
	 * @param packageName
	 * @param tableNames
	 */
	protected void generateByTables(String packageName, String... tableNames) {
		GlobalConfig config = new GlobalConfig();
		config.setDateType(DateType.ONLY_DATE).setActiveRecord(true).setAuthor(author).setOutputDir(outDir)
		.setFileOverride(true);
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.ORACLE).setUrl(dbUrl).setUsername(userName).setPassword(userPass)
				.setDriverName(driverName);
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setCapitalMode(true).setEntityLombokModel(true).setNaming(NamingStrategy.underline_to_camel)
				.setInclude(tableNames);
		AutoGenerator auto = new AutoGenerator();
		auto.setGlobalConfig(config).setDataSource(dataSourceConfig).setStrategy(strategyConfig)
				.setPackageInfo(new PackageConfig().setXml("mapper").setParent(packageName)).execute();
	}

	protected String getDbUrl() {
		return dbUrl;
	}

	protected void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	protected void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	protected void setOutDir(String outDir) {
		this.outDir = outDir;
	}

	protected void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	protected void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 生成代码
	 * 
	 * @param tableNames
	 * @param packageName
	 */
	public abstract void generateCode(String[] tableNames, String packageName);

}
