package com.yizhen.demo.designPattern.structorType.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 子系统类
 * @author liuyizhen
 */
public class CPU {
	public static final Logger LOGGER = LoggerFactory.getLogger(CPU.class);
	    public void start()
	    {
	        LOGGER.info("cpu is start...");
	    }
	     
	    public void shutDown()
	    {
	        LOGGER.info("CPU is shutDown...");
	    }
}
