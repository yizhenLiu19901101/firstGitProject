package com.yizhen.demo.designPattern.builder;


/**
 * 抽象建造者
 * @author liuyizhen
 *
 */
public interface Builder {
	
	/**
	 * 造零件一
	 */
	public void buildPart1();
	
	/**
	 * 造零件二
	 */
	public void buildPart2();
	
	/**
	 * 得到产品
	 * @return
	 */
	public Product retrieveResult();
}