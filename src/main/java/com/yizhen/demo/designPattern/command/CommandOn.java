package com.yizhen.demo.designPattern.command;

public class CommandOn implements CommandI {  
	private Tv myTv;  
	  
    public CommandOn(Tv tv) {  
	  myTv = tv;  
	}  
	  
	public void execute() {  
	   myTv.turnOn();  
	}  
}
