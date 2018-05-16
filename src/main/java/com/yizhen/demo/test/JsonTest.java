package com.yizhen.demo.test;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.yizhen.demo.entities.User;


/**
 * 对象转换为JSON和JSON转换为对象
 * @author liuyizhen
 *
 */
public class JsonTest {
    Logger logger = LoggerFactory.getLogger(JsonTest.class);
    @Ignore
	public void testJsonObject() {
	    User user = new User();
		user.setId("001");
		user.setEmployeeName("jack");
		user.setGender("男");
		logger.info(user+"");
        JSONObject userJson = (JSONObject) JSON.toJSON(user);
        logger.info(userJson.toString());
        User userObject = (User) JSON.toJavaObject(userJson, User.class);
        logger.info(userObject+"");
	}
    
    @Test
    public void testXmlObejct() throws InterruptedException {
    	    User user = new User();
  		user.setId("001");
  		user.setEmployeeName("jack");
  		user.setGender("男");
  		logger.info(user+"");
  	    XStream xstream = new XStream(); 
  		xstream.alias("user", User.class);
  		String xml = xstream.toXML(user); 
        logger.info(xml);
        User userXML = (User) xstream.fromXML(xml);
        logger.info(userXML+"");
    }
}
