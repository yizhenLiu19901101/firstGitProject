package com.yizhen.demo.proxy.cglib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SayHello {  

	private static Logger logger = LoggerFactory.getLogger(SayHello.class);

	public void say(){
	    logger.info("hello everyone");
	}

    public void sayHi(){
		logger.info("hi everyone");
	}
}  

