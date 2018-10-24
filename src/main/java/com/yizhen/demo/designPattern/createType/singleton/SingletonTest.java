package com.yizhen.demo.designPattern.createType.singleton;

import com.yizhen.demo.designPattern.createType.singleton.lazy.FirstSingletonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单例模式
 * Spring对bean实例的创建是采用单例注册表的方式进行实现的，而这个注册表的缓存是HashMap对象
 * @author liuyizhen
 *
 */
public class SingletonTest {
	private static final Logger logger = LoggerFactory.getLogger(SingletonTest.class);
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("使用非线程安全的懒汉式单例模式创建对象");
		//获取唯一可用的对象
	    FirstSingletonObject object = FirstSingletonObject.getInstance();
	    //显示消息
	    object.showMessage();
	}
	
}
