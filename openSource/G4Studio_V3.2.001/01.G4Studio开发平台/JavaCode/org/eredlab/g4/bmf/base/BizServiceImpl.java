package org.eredlab.g4.bmf.base;

import org.eredlab.g4.ccl.properties.PropertiesFactory;
import org.eredlab.g4.ccl.properties.PropertiesFile;
import org.eredlab.g4.ccl.properties.PropertiesHelper;

/**
 * 业务模型实现基类<br>
 * 
 * @author XiongChun
 * @since 2009-07-21
 */
public class BizServiceImpl implements BizService {

	/**
	 * 基类中给子类暴露的一个DAO接口<br>
	 * 连接平台数据库
	 */
	protected Dao g4Dao;
	
	/**
	 * 基类中给子类暴露的一个DAO接口<br>
	 * 连接业务系统数据库
	 */
	protected Dao appDao;

	protected static PropertiesHelper g4PHelper = PropertiesFactory.getPropertiesHelper(PropertiesFile.G4);
	
	protected static PropertiesHelper appPHelper = PropertiesFactory.getPropertiesHelper(PropertiesFile.APP);
    
	public void setG4Dao(Dao g4Dao) {
		this.g4Dao = g4Dao;
	}

	public void setAppDao(Dao appDao) {
		this.appDao = appDao;
	}
}
