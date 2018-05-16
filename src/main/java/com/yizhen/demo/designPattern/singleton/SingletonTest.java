package com.yizhen.demo.designPattern.singleton;

/**
 * 单例模式
 * Spring对bean实例的创建是采用单例注册表的方式进行实现的，而这个注册表的缓存是HashMap对象
 * @author liuyizhen
 *
 */
public class SingletonTest {
	
	public static void main(String[] args) {
		//获取唯一可用的对象
	    FirstSingletonObject object = FirstSingletonObject.getInstance();

	    //显示消息
	    object.showMessage();	
	}
	
}
