package com.yizhen.demo.designPattern.staticMultiMethodFactory;

import com.yizhen.demo.designPattern.plainFactory.Sender;

public class FactoryTest {
	public static void main(String[] args) {      
        Sender sender = SendFactory.produceMail();  
        sender.send();
        sender = SendFactory.produceSms();  
        sender.send();  
    }
}
