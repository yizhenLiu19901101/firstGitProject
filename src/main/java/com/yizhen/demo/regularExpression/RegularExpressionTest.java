package com.yizhen.demo.regularExpression;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 正则表达式，没事儿要多练习
 * @author liuyizhen
 *
 */
public class RegularExpressionTest {

	
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(RegularExpressionTest.class);	
		 String content = "I am noob " +"from runoob.com.";
			 
	     String pattern = ".*runoob.*";
         boolean isMatch = Pattern.matches(pattern, content);
         logger.info("字符串中是否包含了 'runoob' 子字符串? " + isMatch);	
	     content = "a";
	     pattern="[^0-9]";
	     isMatch = Pattern.matches(pattern, content);
	     logger.info("字符串中是否只包含单个数字? " + isMatch);
	     content = "11";
	     pattern="[0-9]";
	     isMatch = Pattern.matches(pattern, content);
	     logger.info("字符串中是否只包含单个数字? " + isMatch);
	     content = "11";
	     pattern="[0-9]+";
	     isMatch = Pattern.matches(pattern, content);
	     logger.info("字符串中是否包含多个数字? " + isMatch);
	     content = "11a";
	     pattern="[0-9]+";
	     isMatch = Pattern.matches(pattern, content);
	     logger.info("字符串中是否只包含多个数字? " + isMatch);
	     content = "11a";
	     pattern="^[0-9]+.*a$";
	     isMatch = Pattern.matches(pattern, content);
	     logger.info("字符串中是否以数字开始，以a结尾? " + isMatch);
	     
	     content = "b1a";
	     pattern= "b([0-9]){1,}a";
	     isMatch = Pattern.matches(pattern, content);
	     logger.info("字符串中是否包含数字? " + isMatch);
	     
	     //要验证的字符串
	     String str = "service@xsoftlab.net";
	     // 邮箱验证规则
	     String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";	   
	     isMatch = Pattern.matches(regEx, str);
	     logger.info("字符串是否邮箱? " + isMatch);
	    
	}
}
