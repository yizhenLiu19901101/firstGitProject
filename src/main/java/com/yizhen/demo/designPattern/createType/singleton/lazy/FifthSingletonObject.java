package com.yizhen.demo.designPattern.createType.singleton.lazy;

/**
 * 登记式/静态内部类，懒汉式
 * @author liuyizhen
 *
 */
public class FifthSingletonObject {
    /**
     * 单例类持有人
     */
    private static class SingletonHolder {
        private static final FifthSingletonObject INSTANCE = new FifthSingletonObject();  
    }

    /**
     * 无参构造器
     */
    private FifthSingletonObject (){
    }

    /**
     * 实例化方法
     * @return
     */
    public static final FifthSingletonObject getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 展示信息
     */
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
