package com.yizhen.demo.designPattern.singleton;

/**
 * 懒汉式，线程安全
 * @author liuyizhen
 *
 */
public class SecondSingletonObject {
    
	private static SecondSingletonObject instance;  
	
	private SecondSingletonObject (){}  
    
	public static synchronized SecondSingletonObject getInstance() {  
        if (instance == null) {  
            instance = new SecondSingletonObject();  
        }  
        return instance;  
    }
	
    public void showMessage(){
	    System.out.println("Hello World!");
	}
}
