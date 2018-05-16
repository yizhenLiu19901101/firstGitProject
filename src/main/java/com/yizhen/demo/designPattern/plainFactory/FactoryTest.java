package com.yizhen.demo.designPattern.plainFactory;

/**
 * 客户
 * 工厂方法：父类定义了创建对象的接口，但是由子类来具体实现，工厂方法让类把实例化的动作推迟到了子类当中。
 * @author liuyizhen
 *
 */
public class FactoryTest {
	public static void main(String[] args) {  
        
		SendFactory factory = new SendFactory();  
        
        Sender sender = factory.produce("sms");  
        
        sender.send();
        
        sender = factory.produce("mail");
        
        sender.send();
	}  
}
