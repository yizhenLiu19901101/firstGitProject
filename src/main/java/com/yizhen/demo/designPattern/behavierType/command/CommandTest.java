package com.yizhen.demo.designPattern.behavierType.command;

/**
 * 命令模式的本质是对命令进行封装，将发出命令的责任和执行命令的责任分割开,命令模式的关键在于引入了抽象命令接口，
 * 且发送者针对抽象命令接口编程，只有实现了抽象命令接口的具体命令才能与接收者相关联
 * @author liuyizhen
 *
 */
public class CommandTest {

	public static void main(String[] args) {
	    //命令接收者Receiver  
		Tv myTv = new Tv();  
		//开机命令ConcreteCommond
	    CommandOn on = new CommandOn(myTv);  
	    //关机命令ConcreteCommond  
	    CommandOff off = new CommandOff(myTv);  
		// 频道切换命令ConcreteCommond  
	    CommandChange channel = new CommandChange(myTv, 2);  
	    // 命令控制对象Invoker  
	    Control control = new Control(on, off, channel);  	  
		//开机  
	    control.turnOn();  
	    //切换频道  
	    control.changeChannel();  
	    //关机  
	    control.turnOff();  
	}
}
