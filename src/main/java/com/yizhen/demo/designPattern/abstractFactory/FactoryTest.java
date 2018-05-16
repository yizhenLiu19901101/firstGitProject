package com.yizhen.demo.designPattern.abstractFactory;

import org.springframework.beans.factory.support.AbstractBeanFactory;

import com.yizhen.demo.designPattern.plainFactory.Sender;

/**
 * 客户角色
 * 抽象工厂模式，由子类完成对象的创建，自己提供接口
 * 是多年业务逻辑的积累导致，大多数业务场景下，对某一类对象总是要执行相同的流程，但是并不在意这些对象之间的微小差异，
 * 这种业务场景就非常符合工厂模式的设计。公共的父类决定了怎么去处理这一类对象，而子类决定了如何创建这些有着微小差异的
 * 不同对象
 * 高层组件应该依赖于低层组件，低层组件为高层组件提供一些最基础的服务，但是工厂模式倒置了这一依赖现象，
 * 让低层组件反而要依赖于统一的抽象接口。工厂模式让高层组件（WebCrawler）和低层组件（ATypeClient|BTypeClient|……）
 * 都依赖于共同的接口（HttpClient），这倒置了原本的依赖模型，解除了高层组件和低层组件之间的强依赖关系
 * 体现依赖倒置原则
 * @author liuyizhen
 *
 */
public class FactoryTest {

	 public static void main(String[] args) {  
		 
	        Provider provider = new SendMailFactory();  
	        Sender sender = provider.produce();  
	        sender.send();
	        provider = new SendSMSFactory();  
	        sender = provider.produce();  
	        sender.send();
	    }  
}
