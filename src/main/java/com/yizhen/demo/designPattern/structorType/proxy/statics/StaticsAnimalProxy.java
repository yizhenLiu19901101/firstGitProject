package com.yizhen.demo.designPattern.structorType.proxy.statics;

import com.yizhen.demo.designPattern.structorType.proxy.entity.Animal;
import com.yizhen.demo.designPattern.structorType.proxy.entity.AnimalImpl;

/**
 * 动物静态代理类
 * @author milo
 */
public class StaticsAnimalProxy implements Animal{

	/**
	 * 目标类
	 */
    private Animal animal = new AnimalImpl();

	@Override
	public void eat(String s) {
		System.out.println("洗手");
		animal.eat(s);
		System.out.println("漱口");
	}
}
