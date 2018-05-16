package com.yizhen.demo.aspect;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLoggingAspect {
	Logger logger = LoggerFactory.getLogger(DemoLoggingAspect.class);
	public void demoBefore(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		logger.info("the method " + methodName + " begins with " + args);
	}
}
