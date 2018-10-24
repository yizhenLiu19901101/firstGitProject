package com.yizhen.demo.designPattern.structorType.bridge;

/**
 * 具体实体类
 * @author liuyizhen
 *
 */
class Bus extends AbstractCar{  
    @Override  
    void run() {  
        super.run();  
        System.out.print("公交车");  
    }  
} 