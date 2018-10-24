package com.yizhen.demo.designPattern.behavierType.status;

public class ConcreteStateA implements State {

    @Override
    public void handle(String sampleParameter) {   
        System.out.println("ConcreteStateA handle ：" + sampleParameter);
    }
}
