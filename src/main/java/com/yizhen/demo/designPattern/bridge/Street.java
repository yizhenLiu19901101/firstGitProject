package com.yizhen.demo.designPattern.bridge;

/**
 * 具体桥接
 * @author liuyizhen
 *
 */
class Street extends AbstractRoad{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        aCar.run();  
        System.out.println("在市区街道行驶");  
    }  
} 
