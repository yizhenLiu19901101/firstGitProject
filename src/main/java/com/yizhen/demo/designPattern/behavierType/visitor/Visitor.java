package com.yizhen.demo.designPattern.behavierType.visitor;

/**
 * 具体访问者
 * @author liuyizhen
 *
 */
class Visitor implements IVisitor {    
    
    public void visit(ConcreteElement1 el1) {    
        el1.doSomething();    
    }    
        
    public void visit(ConcreteElement2 el2) {    
        el2.doSomething();    
    }    
} 
