package com.yizhen.demo.designPattern.createType.singleton.hungery;

/**
 * 饿汉式，被推荐使用
 * @author liuyizhen
 *
 */
public class ThirdSingletonObject {
    /**
     * 静态的私有成员变量
     */
    private static ThirdSingletonObject instance = new ThirdSingletonObject();

    /**
     * 无参构造器
     */
    private ThirdSingletonObject (){}

    /**
     * 实例化方法
     * @return
     */
    public static ThirdSingletonObject getInstance() {
        return instance;
    }

    /**
     * 展示信息
     */
	public void showMessage(){
        System.out.println("Hello World!");
	}
}
