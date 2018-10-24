package com.yizhen.demo.designPattern.createType.factory.staticMultiMethodFactory;

import com.yizhen.demo.designPattern.createType.factory.plainFactory.Sender;

/**
 * 多静态方法工厂测试类
 * @author  milo
 */
public class FactoryTest {
    /**
     * 程序入口
     * @param args
     */
	public static void main(String[] args) {      

	    Sender sender = SendFactory.produceMail();
        sender.send();

        sender = SendFactory.produceSms();
        sender.send();  
    }
}
