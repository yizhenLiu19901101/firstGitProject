package com.yizhen.demo.proxy.statics;

import com.yizhen.demo.proxy.entity.Animal;
import com.yizhen.demo.proxy.entity.AnimalImpl;

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
