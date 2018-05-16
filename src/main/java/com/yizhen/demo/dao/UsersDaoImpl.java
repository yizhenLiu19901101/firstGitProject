package com.yizhen.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.yizhen.demo.base.CommonDao;
import com.yizhen.demo.entities.User;

@Repository(value="usersDao")
public class UsersDaoImpl extends CommonDao implements UsersDao {

	
	public List<User> selectUser(String id) {
	    return sqlSessionTempalte.selectList("selectUser", id);
	}

	public List<User> queryUser() {     
	    List<User> users = null;
	    users = sqlSessionTempalte.selectList("queryUser");
	    return users;         
	}

	public void updateOneUser(User user) {
		sqlSessionTempalte.update("updateOneUser", user);
	}

	public void addOneUser(User user) {
	    sqlSessionTempalte.insert("addOneUser", user);
	}

	public void deleteOneUser(String id) {
	    sqlSessionTempalte.delete("deleteOneUser", id);
	}

	@Override
	public List<User> getUserCount(HashMap<String,Object> map) {
		return sqlSessionTempalte.selectList("getUserCount",map);
	}
}
