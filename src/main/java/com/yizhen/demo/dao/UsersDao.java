package com.yizhen.demo.dao;

import java.util.HashMap;
import java.util.List;

import com.yizhen.demo.entities.User;

public interface UsersDao {

	/*
	 * 查询一个用户
	 */
	public List<User> selectUser(String id);
	
	/*
	 * 查询所有用户
	 */
	public List<User> queryUser();
	
	/*
	 * 更新一个用户
	 */
	public void updateOneUser(User user);
	
	/*
	 * 新增一个用户
	 */
	public void addOneUser(User user);
	
	/*
	 * 删除一个用户
	 */
	public void deleteOneUser(String id);
	
	/*
	 * 调用存储过程
	 */
	public List<User> getUserCount(HashMap<String,Object> map);
}
