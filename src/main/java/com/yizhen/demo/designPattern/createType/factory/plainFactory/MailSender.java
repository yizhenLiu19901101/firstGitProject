package com.yizhen.demo.designPattern.createType.factory.plainFactory;

/**
 * 具体产品
 * @author liuyizhen
 */
public class MailSender implements Sender {
	@Override
	public void send() {
		System.out.println("this is mail sender!");
	}
}
