package com.yizhen.demo.designPattern.behavierType.visitor;

/**
 * 具体元素角色
 * @author liuyizhen
 *
 */
class ConcreteElement1 extends Element {    
    public void doSomething(){    
        System.out.println("这是元素1");    
    }    
        
    public void accept(IVisitor visitor) {    
        visitor.visit(this);    
    }    
}  