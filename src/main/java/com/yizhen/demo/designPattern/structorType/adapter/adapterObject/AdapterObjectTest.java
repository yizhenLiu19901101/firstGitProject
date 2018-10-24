package com.yizhen.demo.designPattern.structorType.adapter.adapterObject;

import com.yizhen.demo.designPattern.structorType.adapter.adapterClass.Adaptee;


/**
 * 适配器模式把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作,
 * Adaptee和Adapter的关系是委派，而非继承，它决定了这是对象适配，建议使用这种方式
 * 缺省适配器模式是一个变体，它是使用抽象类（适配器类）实现接口的所有方法的平庸实现，目标类集成该适配器类
 * Spring中用到该适配模式
 * @author liuyizhen
 *
 */
public class AdapterObjectTest {
	public static void main(String[] args) {
		Adaptee adaptee = new Adaptee();
		Adapter adapter = new Adapter(adaptee);
		adapter.sampleOperation1();
		adapter.sampleOperation2();
	}
}
