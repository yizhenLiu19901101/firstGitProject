package com.yizhen.demo.designPattern.behavierType.iterator.blackIterator;


public abstract class IteratorAggregate {
	 /** 
     * 工厂方法，创建相应迭代子对象的接口 
     */  
    public abstract Iterator createIterator();  
}
