package com.yizhen.demo.designPattern.singleton;

/**
 * 双重锁，懒汉式
 * @author liuyizhen
 *
 */
public class FourthSingletonObject {
	private volatile static FourthSingletonObject singleton;
	 
    private FourthSingletonObject (){}  
    public static FourthSingletonObject getSingleton() {  
		if (singleton == null) {  
		    synchronized (FourthSingletonObject.class) {  
			    if (singleton == null) {  
			        singleton = new FourthSingletonObject();  
			    }  
		    }  
		}  
		return singleton;  
    }  
}
