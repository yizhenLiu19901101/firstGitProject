package com.yizhen.demo.designPattern.bridge;

/**
 * 具体实体类
 * @author liuyizhen
 *
 */
class Car extends AbstractCar{  
    @Override  
    void run() {  
        super.run();  
        System.out.print("小汽车");  
    }  
} 