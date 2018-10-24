package com.yizhen.demo.designPattern.createType.factory.staticMultiMethodFactory;

import com.yizhen.demo.designPattern.createType.factory.plainFactory.MailSender;
import com.yizhen.demo.designPattern.createType.factory.plainFactory.Sender;
import com.yizhen.demo.designPattern.createType.factory.plainFactory.SmsSender;

/**
 * 	静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
 *  使用得比较多
 * @author liuyizhen
 *
 */
public class SendFactory {
	/**
	 * 生产邮件服务器
	 * @return
	 */
	public static Sender produceMail(){  
	    return new MailSender();  
	}

	/**
	 * 生产短消息服务器
	 * @return
	 */
	public static Sender produceSms(){  
        return new SmsSender();  
	} 
}
