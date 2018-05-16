package com.yizhen.demo.designPattern.singleton;

/**
 * 懒汉式，线程不安全
 * @author liuyizhen
 *
 */
public class FirstSingletonObject {

    private static FirstSingletonObject instance;  
    
    private FirstSingletonObject (){}  
  
    public static FirstSingletonObject getInstance() {  
    if (instance == null) {  
        instance = new FirstSingletonObject();  
    }  
    return instance;  
    }  

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
