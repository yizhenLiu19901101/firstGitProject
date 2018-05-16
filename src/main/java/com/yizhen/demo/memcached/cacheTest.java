package com.yizhen.demo.memcached;

import java.net.InetSocketAddress;

import com.yizhen.demo.entities.User;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

public class cacheTest {

	public static void main(String[] args) {
		 try{
	         // 本地连接 Memcached 服务
	         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	         System.out.println("Connection to server sucessful."); 
	         User user = new User();
	         user.setEmployeeName("mike");
	         user.setGender("1");
	         user.setId("1");
	         // 存储数据
	         OperationFuture<Boolean> fo = mcc.set("runoob", 900,user);
	      
	         // 查看存储状态
	         System.out.println("set status:" + fo.get());
	         user = (User) mcc.get("runoob");
	         // 输出值
	         System.out.println("user=" + user);

	         mcc.shutdown();
	      }catch(Exception ex){
	         System.out.println( ex.getMessage() );
	      }

	}

}
