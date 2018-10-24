package com.yizhen.demo.designPattern.behavierType.command;

/**
 * 调用者
 * @author liuyizhen
 *
 */
public class Control {  
	private CommandI onCommand, offCommand, changeChannel;  
	  
	public Control(CommandI on, CommandI off, CommandI channel) {  
	    onCommand = on;  
	    offCommand = off;  
	    changeChannel = channel;  
	}  
	  
	public void turnOn() {  
	    onCommand.execute();  
	}  
	  
	public void turnOff() {  
	    offCommand.execute();  
	}  
	  
	public void changeChannel() {  
	    changeChannel.execute();  
	}  
} 