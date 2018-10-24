package com.yizhen.demo.designPattern.createType.factory.plainFactory;

/**
 * 普通工厂模式
 * @author liuyizhen
 *
 */
public class SendFactory {
    /**
     * 生产
     * @param type
     * @return
     */
	public Sender produce(String type) {
        //根据不同类型来生产不同的东西
        if (MessageType.MS.getKey().equals(type)) {
            return new MailSender();  
        } else if (MessageType.SMS.getKey().equals(type)) {
            return new SmsSender();  
        } else {
            return null;  
        }  
    }  
}
