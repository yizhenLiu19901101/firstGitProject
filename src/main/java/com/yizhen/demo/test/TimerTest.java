package com.yizhen.demo.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 *  定时器
 *  
 * @author liuyizhen
 *  
 */ 

public class TimerTest {
    public static void main(String[] args) {
    	Logger logger = LoggerFactory.getLogger(TimerTest.class);
        Runnable runnable = new Runnable() {  
            public void run() {
            	logger.info("Hello,Timer !!");
            }  
        };  
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();  
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);  
    }  
}  
