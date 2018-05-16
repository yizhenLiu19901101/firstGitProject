package com.yizhen.demo.test;

import java.sql.SQLException;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yizhen.demo.dao.CityDao;
import com.yizhen.demo.dao.CustomerContextHolder;
import com.yizhen.demo.dao.UsersDao;
import com.yizhen.demo.entities.User;

/*
 * MyBatis和Spring整合，使用ID寻址的方式（共有配置、ID寻址两种方式）实现增删改查
 */

public class UserTest {
	private Logger logger = LoggerFactory.getLogger(UserTest.class);
	ApplicationContext ctx;
	UsersDao usersDao;
	CityDao cityDao;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-demo.xml");
		usersDao = (UsersDao) ctx.getBean("usersDao");
		//设置数据源
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_A);
	}

	/**
	 * 查询所有的用户
	 * @throws SQLException
	 */
	@Ignore
	public void testGetAllUsers() throws SQLException{
	    List<User> users = usersDao.queryUser();
	    for(User user:users){
	    	System.out.println(user);
	    }
	}
	
	/**
	 * 查询指定的一个用户
	 * @throws SQLException
	 */
	@Test
	public void testOneUser() throws SQLException{
//		User user = usersDao.selectUser("2");
//		logger.info("employeeName = "+user.getEmployeeName()+"**employeeId = "+user.getId()+"**gender = "+user.getGender());
	}
	
	
	/**
	 * 更新指定用户的信息
	 * @throws SQLException
	 */
	@Ignore
	public void testUpdateUser() throws SQLException{
	//	User user = new User();
	//	user.setUser_name("xue.Zhang");
	//	usersDao.addOneUser(user);
	}
	
	/**
	 * 删除指定用户的信息
	 */
	@Ignore
   public void testDeleteUser() throws SQLException{
	   usersDao.deleteOneUser("2");
   }
}
