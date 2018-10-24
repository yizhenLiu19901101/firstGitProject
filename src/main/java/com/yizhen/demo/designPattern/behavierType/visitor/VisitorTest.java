package com.yizhen.demo.designPattern.behavierType.visitor;

import java.util.List;

/**
 * 访问者模式，封装某些作用于某种数据结构中各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作，
 * 比较适用于对已有功能的重构
 * 适合于业务处理时常发生变动的情况
 * @author liuyizhen
 *
 */
public class VisitorTest {

	public static void main(String[] args){    
        List<Element> list = ObjectStruture.getList();    
        for(Element e: list){    
            e.accept(new Visitor());    
        }    
    }   
}
