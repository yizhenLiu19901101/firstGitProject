package com.yizhen.demo.designPattern.plainFactory;

/**
 * 具体产品
 * @author liuyizhen
 *
 */
public class MailSender implements Sender {

	@Override
	public void send() {
        System.out.println("this is mailsender!");  
	}

}
