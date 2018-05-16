package com.yizhen.demo.proxy.entity;

public class AnimalImpl implements Animal {

	@Override
	public void eat(String s) {
		System.out.println("吃"+s);
	}

}
