package com.yizhen.demo.designPattern.createType.factory.abstractFactory;

import com.yizhen.demo.designPattern.createType.factory.plainFactory.Sender;
import com.yizhen.demo.designPattern.createType.factory.plainFactory.SmsSender;

/**
 * 具体工厂
 * @author liuyizhen
 *
 */
public class SendSMSFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}	
}
