package com.yizhen.demo.mongo;


import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import com.yizhen.demo.entities.User;



public class SpringMongoTest {

	@Autowired
    private MongoTemplate mongoTemplate;

    //使用spring整合的话, 就直接注入就可以了
    @Before
    public void testBefore() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-demo.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
    }

	    /**
	     * 插入用户信息
	     */
	    @Ignore
	    public void testAddUser() {
	        User zhanggc = new User();
	        zhanggc.setEmployeeName("zhenzhen");
	        zhanggc.setGender("1");
	        //插入数据
	        mongoTemplate.insert(zhanggc);
	    }
	    
	    /**
	     * 查看所有用户信息
	     */
	    @Test
	    public void queryAll(){
    	    List<User> users = mongoTemplate.findAll(User.class);
	    	for(User user:users){
	    		System.out.println(user);
	    	}
	    }
	    
	    /**
	     * 查看特定用户信息
	     */
	    @Ignore
	    public void queryByCondition(){
		    Query query = new Query();	    
	        Criteria criteria = where("gender").gte("0");// 大于
		    query.addCriteria(criteria);
		    	List<User> users = mongoTemplate.find(query, User.class);	    	
		    	for(User user:users){
		    		System.out.println(user);
		    	}
	    }
	    
}
