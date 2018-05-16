package com.yizhen.demo.designPattern.visitor;

/**
 * 抽象访问者
 * @author liuyizhen
 *
 */
public interface IVisitor {    
    public void visit(ConcreteElement1 el1);    
    public void visit(ConcreteElement2 el2);    
} 