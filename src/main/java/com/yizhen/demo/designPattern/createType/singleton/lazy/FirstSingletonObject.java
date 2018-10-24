package com.yizhen.demo.designPattern.createType.singleton.lazy;

/**
 * 懒汉式，非线程安全（非线程安全是指多线程操作同一个对象可能会出现问题，而线程安全则是多线程操作同一个对象不会有问题）,用的时候才创建
 * @author liuyizhen
 *
 */
public class FirstSingletonObject {
    private static FirstSingletonObject instance;
    /**
     * 无参构造器
     */
    private FirstSingletonObject (){}

    /**
     * 实例化方法
     * @return
     */
    public static FirstSingletonObject getInstance() {
        if (instance == null) {
            instance = new FirstSingletonObject();
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
