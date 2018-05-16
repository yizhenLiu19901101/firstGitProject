package com.yizhen.demo.designPattern.command;

public class CommandChange implements CommandI {  
	private Tv myTv;  
	private int channel;  
	  
	public CommandChange(Tv tv, int channel) {  
	   myTv = tv;  
	   this.channel = channel;  
	}  
	  
	public void execute() {  
	  myTv.changeChannel(channel);  
	}  
} 