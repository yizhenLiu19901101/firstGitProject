package com.yizhen.demo.proxy.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 长于生成类文件
 * @author Administrator
 *
 */
public class DynamicsAnimalProxy implements InvocationHandler {

	private Object object;//用于接收具体实现类的实例对象
	//使用带参数的构造器来传递具体实现类的对象
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
