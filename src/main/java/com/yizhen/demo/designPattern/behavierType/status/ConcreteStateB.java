package com.yizhen.demo.designPattern.behavierType.status;

public class ConcreteStateB implements State {

    @Override
    public void handle(String sampleParameter) {   
        System.out.println("ConcreteStateB handle ：" + sampleParameter);
    }
}
