package com.yizhen.demo.test;

import java.sql.SQLException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yizhen.demo.dao.CityDao;
import com.yizhen.demo.dao.CustomerContextHolder;
import com.yizhen.demo.entities.City;

public class CityTest {

	private static final Logger logger = LoggerFactory.getLogger(CityTest.class);  
	ApplicationContext ctx;
	
	CityDao cityDao;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-demo.xml");
		cityDao = (CityDao) ctx.getBean("cityDao");
		//设置数据源
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_B);
	}
	
	/**
	 * 查询指定的一个城市
	 * @throws SQLException
	 */
	@Test
	public void testOneCity() throws SQLException{
		City city =cityDao.selectCity("1");
		logger.info("cityId = "+city.getId()+"**cityName = "+city.getCityName()+"**cityCode = "+city.getCityCode());
	}
}
