package com.yizhen.demo.designPattern.behavierType.visitor;

/**
 * 抽象元素角色
 * @author liuyizhen
 *
 */
public abstract class Element {
	 
	public abstract void accept(IVisitor visitor);    
	 
	 public abstract void doSomething();    
}
