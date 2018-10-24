package com.yizhen.demo.designPattern.createType.factory.abstractFactory;

import com.yizhen.demo.designPattern.createType.factory.plainFactory.MailSender;
import com.yizhen.demo.designPattern.createType.factory.plainFactory.Sender;

/**
 * 具体工厂
 * @author liuyizhen
 *
 */
public class SendMailFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSender();  
	}	
}
