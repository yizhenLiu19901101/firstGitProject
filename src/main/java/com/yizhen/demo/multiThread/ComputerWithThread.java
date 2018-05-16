package com.yizhen.demo.multiThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 集成Thread类
 * @author Administrator
 *
 */

public class ComputerWithThread{

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();	
	}	
}


class MyThread extends Thread{
    Logger logger =LoggerFactory.getLogger(MyThread.class);
	@Override
	public void run() {
	    logger.info("MyThread run...");
	}

}