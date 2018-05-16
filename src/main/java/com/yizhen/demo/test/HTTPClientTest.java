package com.yizhen.demo.test;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yizhen.demo.utils.HttpClientUtil;

public class HTTPClientTest {
	Logger logger = LoggerFactory.getLogger(HTTPClientTest.class);
	private String url = "http://localhost:8080/";  
    private String charset = "utf-8";  
    private HttpClientUtil httpClientUtil = null;  
      
    public HTTPClientTest(){  
        httpClientUtil = new HttpClientUtil();  
    }  
      
    public void testPost(){  
        String httpOrgCreateTest = url + "qjsc/app/service/mainservice";  
        Map<String,String> createMap = new HashMap<String,String>();  
        createMap.put("inputStr","{\r\n" + 
        		"    \"comm\": \"0608\",\r\n" + 
        		"    \"sign\": \"2RmQrwu2Dj5+Jxc7bZtV3cEAiJcOMasqsfpldMPSSUclipdavs5LYxqrzS1kDvu0/JGq/GuQGpsBdpXpugdNvpSqa9H9Z8JjvlAWzh+B4LjHn1JD6+OIUzD6jQIDX7wItJsQNg9MzM98UvjztFdcbjvFvoIG48dBwTgwRlfFYg4=\",\r\n" + 
        		"    \"random\": \"20170322015122\",\r\n" + 
        		"    \"nickName\": \"米罗\"\r\n" + 
        		"}");  
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);  
        System.out.println("result:"+httpOrgCreateTestRtn);  
    }  
      
    public static void main(String[] args){  
    	HTTPClientTest main = new HTTPClientTest();  
        main.testPost();  
    }  
}
