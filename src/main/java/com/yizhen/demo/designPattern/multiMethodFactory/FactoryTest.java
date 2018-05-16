package com.yizhen.demo.designPattern.multiMethodFactory;

import com.yizhen.demo.designPattern.plainFactory.Sender;

public class FactoryTest {
	public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceMail();  
        sender.send();
        sender = factory.produceSms();
        sender.send();
    }  
}
