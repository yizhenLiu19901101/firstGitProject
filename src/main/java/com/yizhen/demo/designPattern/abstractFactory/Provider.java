package com.yizhen.demo.designPattern.abstractFactory;

import com.yizhen.demo.designPattern.plainFactory.Sender;

/**
 * 抽象工厂
 * @author liuyizhen
 *
 */
public interface Provider {
	  public Sender produce();  
}
