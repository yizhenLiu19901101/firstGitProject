package com.yizhen.demo.designPattern.createType.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 原型模式测试类
 * @author  milo
 */
public class PrototypeTest {
	private final static Logger logger = LoggerFactory.getLogger(PrototypeTest.class);
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle("红色的");
		for(int i = 0; i < 3; i++){
        	Rectangle cloneCp = (Rectangle) rectangle.clone();
			logger.info("rectangle和cloneCp"+i+"是否是同一个对象？"+(rectangle == cloneCp)+" "+cloneCp.getLabel());
            cloneCp.draw();
        } 
	}
}
