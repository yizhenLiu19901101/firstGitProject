package com.yizhen.demo.designPattern.abstractFactory;

import com.yizhen.demo.designPattern.plainFactory.MailSender;
import com.yizhen.demo.designPattern.plainFactory.Sender;

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
