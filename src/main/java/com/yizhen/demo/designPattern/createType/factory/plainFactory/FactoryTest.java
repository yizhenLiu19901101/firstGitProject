package com.yizhen.demo.designPattern.createType.factory.plainFactory;

/**
 * 客户
 * 工厂方法：父类定义了创建对象的接口，但是由子类来具体实现，工厂方法让类把实例化的动作推迟到了子类当中。
 * @author liuyizhen
 *
 */
public class FactoryTest {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        try{
		    SendFactory factory = new SendFactory();
            //发短消息
		    Sender sender = factory.produce(MessageType.SMS.getKey());
            sender.send();
            //发邮件
            sender = factory.produce(MessageType.MS.getKey());
            sender.send();
            //发货
            sender = factory.produce(MessageType.TS.getKey());
            sender.send();
        }catch(NullPointerException ex){
            System.out.println("工厂不生成该产品");
        }
    }
}
