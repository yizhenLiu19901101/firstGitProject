package com.yizhen.demo.designPattern.createType.builder;


/**
 * 抽象建造者
 * @author liuyizhen
 *
 */
public interface Builder {
	
	/**
	 * 写编号
	 */
	void buildCode();
	
	/**
	 * 起名字
	 */
	void buildName();
	
	/**
	 * 得到产品
	 * @return
	 */
	Product retrieveResult();
}