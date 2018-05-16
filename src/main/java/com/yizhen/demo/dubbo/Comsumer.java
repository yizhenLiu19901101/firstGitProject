package com.yizhen.demo.dubbo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Comsumer {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Comsumer.class);
		  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	                "classpath*:applicationContext-dubbo-client.xml");
		  IProduct productService = (IProduct) context.getBean("productService");		
		  logger.info(productService.getProductName("雪雪"));
	}  

}
