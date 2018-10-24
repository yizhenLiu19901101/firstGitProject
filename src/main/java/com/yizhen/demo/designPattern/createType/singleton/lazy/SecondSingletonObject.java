package com.yizhen.demo.designPattern.createType.singleton.lazy;

/**
 * 懒汉式，线程安全
 * @author liuyizhen
 *
 */
public class SecondSingletonObject {

    /**
     * 私有成员变量
     */
    private static SecondSingletonObject instance;

    /**
     * 无参构造器
     */
	private SecondSingletonObject (){}

    /**
     * 实例化方法，加synchronized是为了同步控制
     * @return
     */
	public static synchronized SecondSingletonObject getInstance() {  
        if (instance == null) {  
            instance = new SecondSingletonObject();  
        }  
        return instance;  
    }

    /**
     * 展示信息
     */
    public void showMessage(){
	    System.out.println("Hello World!");
	}
}
