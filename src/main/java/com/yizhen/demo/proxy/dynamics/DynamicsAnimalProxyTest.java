package com.yizhen.demo.proxy.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import com.yizhen.demo.proxy.entity.Animal;
import com.yizhen.demo.proxy.entity.AnimalImpl;

/**
 * 利用反射实现的代理，目标类需要基于统一的接口
 * @author Administrator
 *
 */
public class DynamicsAnimalProxyTest {
	public static void main(String[] args) {
        Animal animal = new AnimalImpl();
        InvocationHandler h = new DynamicsAnimalProxy(animal);
        Animal proxy = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, h);
        proxy.eat("香蕉");
    }
}
