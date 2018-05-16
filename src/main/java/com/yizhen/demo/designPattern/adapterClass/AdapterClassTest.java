package com.yizhen.demo.designPattern.adapterClass;


/**
 * 适配器模式把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作，这个是类适配
 * @author liuyizhen
 *
 */
public class AdapterClassTest {

	public static void main(String[] args) {
		Target target = new Adapter();
	    target.sampleOperation2();
	}

}
