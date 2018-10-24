package com.yizhen.demo.designPattern.structorType.decorator;

/**
 * 装饰器模式,抽象装饰
 * @author liuyizhen
 *
 */
public class Change implements TheGreatestSage {
    private TheGreatestSage sage;
    
    public Change(TheGreatestSage sage){
        this.sage = sage;
    }
    
    @Override
    public void move() {
        // 代码
        sage.move();
    }
}

