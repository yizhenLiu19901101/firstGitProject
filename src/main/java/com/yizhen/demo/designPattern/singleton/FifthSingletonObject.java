package com.yizhen.demo.designPattern.singleton;

/**
 * 登记式/静态内部类
 * @author liuyizhen
 *
 */
public class FifthSingletonObject {
    private static class SingletonHolder {  
        private static final FifthSingletonObject INSTANCE = new FifthSingletonObject();  
    }  
    private FifthSingletonObject (){}  
    
    public static final FifthSingletonObject getInstance() {  
	    return SingletonHolder.INSTANCE;  
    }  
}
