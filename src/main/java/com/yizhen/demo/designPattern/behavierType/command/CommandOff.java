package com.yizhen.demo.designPattern.behavierType.command;

/**
 * 具体命令
 * @author liuyizhen
 *
 */
public class CommandOff implements CommandI {  
	private Tv myTv;  
	  
	public CommandOff(Tv tv) {  
        myTv = tv;  
	}  
	  
	public void execute() {  
	    myTv.turnOff();  
	}  
}  
