package com.yizhen.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciTest {  
	  
    public static void main(String[] args) {  
    	//统一化日志输出
    	Logger logger = LoggerFactory.getLogger(FibonacciTest.class);    
        fibonacci(logger,6);
        
        //双重循环
        for(int i = 0;i < 5;i++) {
        	for(int j = 0;j <= i;j++) {
        		System.out.print("-");
        	}
        	System.out.println();
        }
        System.out.println("-----------------------------");
        //双重循环
        for(int i = 5;i > 0;i--) {
        	for(int j = 0;j < i;j++) {
        		System.out.print("+");
        	}
        	System.out.println();
        }
        System.out.println("-----------------------------");
        //双重循环
        for(int i = 3;i > 0;i--) {
        	for(int j = 1;j <= 5;j++) {
        	    if(j == i) {	
        	    	System.out.print("*");
        	    }
        	    if(j < i) {	
        	    	System.out.print(" ");    	
        	    }
        	}
        	System.out.println();
        }
    }  
      
    //递归实现方式  
    public static void fibonacci(Logger logger,int n){
        if(n==2) {
    	    logger.info("++"+n+"++");        	
        }else {
        	logger.info("--"+n+"--");  
        	fibonacci(logger,n-2);
        	logger.info("--"+n+"--");  
        }
    }
}