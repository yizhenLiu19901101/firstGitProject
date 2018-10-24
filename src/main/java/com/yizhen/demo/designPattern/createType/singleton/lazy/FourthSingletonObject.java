package com.yizhen.demo.designPattern.createType.singleton.lazy;

/**
 * 双重锁，懒汉式
 * @author liuyizhen
 *
 */
public class FourthSingletonObject {
	/**
	 * 私有成员变量
	 */
	private volatile static FourthSingletonObject singleton;

	/**
	 * 无参构造器
 	 */
    private FourthSingletonObject (){
	}

	/**
	 * 实例化方法
	 * @return
	 */
    public static FourthSingletonObject getSingleton() {  
		if (singleton == null) {
			//同步块
			synchronized (FourthSingletonObject.class) {
			    if (singleton == null) {  
			        singleton = new FourthSingletonObject();  
			    }  
		    }  
		}  
		return singleton;  
    }

	/**
	 * 展示信息
	 */
	public void showMessage(){
		System.out.println("Hello World!");
	}
}
