package com.yizhen.demo.designPattern.abstractFactory;

import com.yizhen.demo.designPattern.plainFactory.Sender;
import com.yizhen.demo.designPattern.plainFactory.SmsSender;

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
