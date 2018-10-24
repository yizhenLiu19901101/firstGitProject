package com.yizhen.demo.designPattern.structorType.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 子系统类
 * @author liuyizhen
 *
 */
public class Disk {
	public static final Logger LOGGER = LoggerFactory.getLogger(Disk.class);
	    public void start()
	    {
	        LOGGER.info("Disk is start...");
	    }
	     
	    public void shutDown()
	    {
	        LOGGER.info("Disk is shutDown...");
	    }
}
