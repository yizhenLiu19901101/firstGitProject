package com.yizhen.demo.designPattern.multiMethodFactory;

import com.yizhen.demo.designPattern.plainFactory.MailSender;
import com.yizhen.demo.designPattern.plainFactory.Sender;
import com.yizhen.demo.designPattern.plainFactory.SmsSender;

/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，
 * 在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，
 * 而多个工厂方法模式是提供多个工厂方法，分别创建对象
 * @author liuyizhen
 *
 */
public class SendFactory {
	public Sender produceMail(){  
        return new MailSender();  
    }  
      
    public Sender produceSms(){  
        return new SmsSender();  
    }  
}
