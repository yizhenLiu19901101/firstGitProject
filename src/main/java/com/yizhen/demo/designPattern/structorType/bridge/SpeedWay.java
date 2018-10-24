package com.yizhen.demo.designPattern.structorType.bridge;

/**
 * 具体桥接
 * @author liuyizhen
 *
 */
class SpeedWay extends AbstractRoad{  
    @Override  
    void run() {  
        // TODO Auto-generated method stub  
        super.run();  
        aCar.run();  
        System.out.println("在高速公路行驶");  
    }  
}
