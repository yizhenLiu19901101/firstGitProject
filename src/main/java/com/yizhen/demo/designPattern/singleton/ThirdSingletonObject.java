package com.yizhen.demo.designPattern.singleton;

/**
 * 饿汉式，被推荐使用
 * @author liuyizhen
 *
 */
public class ThirdSingletonObject {
    private static ThirdSingletonObject instance = new ThirdSingletonObject();  
    
    private ThirdSingletonObject (){}  
    
    public static ThirdSingletonObject getInstance() {  
        return instance;  
    }  
	
	public void showMessage(){
        System.out.println("Hello World!");
	}
}
