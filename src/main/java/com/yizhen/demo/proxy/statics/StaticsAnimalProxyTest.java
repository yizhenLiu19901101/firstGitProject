package com.yizhen.demo.proxy.statics;

/**
 * 静态代理测试类
 */
public class StaticsAnimalProxyTest {
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 代理类
		 */
		StaticsAnimalProxy proxy = new StaticsAnimalProxy();
		proxy.eat("苹果");
	}
}
