package com.yizhen.demo.designPattern.createType.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户
 * 建造模式利用一个导演者对象和具体建造者对象一个个地建造出所有的零件，从而建造出完整的产品对象。
 * 建造者模式将产品的结构和产品的零件的建造过程对客户端隐藏起来，把对建造过程进行指挥的责任和具体建造零件的责任分割开来，达到责任划分和封装的目的
 * 应用很广泛
 * @author liuyizhen
 *
 */

public class BuilderTest {
	private static final Logger logger = LoggerFactory.getLogger(BuilderTest.class);
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {  
		//做准备工作
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		//造产品
		director.construct();
		//检查产品
		Product product = builder.retrieveResult();
		logger.info(product.getCode());
		logger.info(product.getName());
	}  
}
