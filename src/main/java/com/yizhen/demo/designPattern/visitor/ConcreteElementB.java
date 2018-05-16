package com.yizhen.demo.designPattern.visitor;

class ConcreteElement2 extends Element {    
    public void doSomething(){    
        System.out.println("这是元素2");    
    }    
        
    public void accept(IVisitor visitor) {    
        visitor.visit(this);
    }    
} 