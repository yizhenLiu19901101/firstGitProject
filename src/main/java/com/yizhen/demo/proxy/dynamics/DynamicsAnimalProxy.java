package com.yizhen.demo.proxy.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理（长于生成类文件）
 * @author milo
 *
 */
public class DynamicsAnimalProxy implements InvocationHandler {
	/**
	 * 用于接收具体实现类的实例对象
	 */
	private Object object;

	/**
	 * 带参数构造器
	 * @param object
	 */
	public DynamicsAnimalProxy(Object object) {
		super();
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("洗手");
		method.invoke(object, args);
		System.out.println("漱口");
		return null;
	}
}
