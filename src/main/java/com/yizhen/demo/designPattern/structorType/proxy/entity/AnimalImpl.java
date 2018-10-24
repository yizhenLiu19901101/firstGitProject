package com.yizhen.demo.designPattern.structorType.proxy.entity;

/**
 * 动物类
 * @author milo
 */
public class AnimalImpl implements Animal {
	@Override
	public void eat(String s) {
		System.out.println("吃"+s);
	}
}
