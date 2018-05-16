package com.yizhen.demo.proxy.statics;

import com.yizhen.demo.proxy.entity.Animal;
import com.yizhen.demo.proxy.entity.AnimalImpl;

public class StaticsAnimalProxy implements Animal{

    private Animal animal = new AnimalImpl();
	
	@Override
	public void eat(String s) {
		System.out.println("洗手");
		animal.eat(s);
		System.out.println("漱口");
	}
}
