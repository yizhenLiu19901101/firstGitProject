package com.yizhen.demo.http;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpTest {

	public static void main(String[] args) {
		  System.out.println(queryDeliveryInfo("31913758256423",2).toString()); 
	}

    public static JSONObject queryDeliveryInfo(String deliveryNo,int type){
	    String host = "https://ali-deliver.showapi.com";
	    String path = "/showapi_expInfo";
	    String method = "GET";
	    String appcode = "811ea081399e4fbd8c3dc650477ee944";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("com", "auto");
	    querys.put("nu", deliveryNo);

	    try {
	       	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	//核心代码
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println(response.toString());
	    	JSONObject jsonObject = (JSONObject) JSONObject.parse(EntityUtils.toString(response.getEntity()));
	    	//获取response的body
	    	int responseCode =  (Integer) jsonObject.get("showapi_res_code");
	        if(responseCode == 0){
	        	JSONObject resBody = (JSONObject) jsonObject.get("showapi_res_body");
	        	String mailNo = String.valueOf(resBody.get("mailNo"));
	        JSONObject goalData = new JSONObject();
	        	goalData.put("mailNo", mailNo);
	        	int status = (Integer) resBody.get("status");
	        	switch (status){
	        	    case -1:
        			    goalData.put("status", "待查询");break;
	        	    case 0:
	        	    	goalData.put("status", "查询异常");break;
	        	    case 1:
        			    goalData.put("status", "暂无记录");break;
	        	    case 2:
	        	    	goalData.put("status", "在途中");break;
	        	    case 3:
        			    goalData.put("status", "派送中");break;
	        	    case 4:
	        	    	goalData.put("status", "已签收");break;
	        	    case 5:
        			    goalData.put("status", "用户拒签");break;
	        	    case 6:
	        	    	goalData.put("status", "疑难件");break;
	        	    case 7:
	        	    	goalData.put("status", "无效单");break;
	        	    case 8:
        			    goalData.put("status", "超时单");break;
	        	    case 9:
	        	    	goalData.put("status", "签收失败");break;
	        	    case 10:
	        	    	goalData.put("status", "退回");break;
        	
	        	}
	        	String expTextName =  String.valueOf(resBody.get("expTextName"));
	        	goalData.put("expTextName", expTextName);
	        	String tel = String.valueOf(resBody.get("tel"));
	        	goalData.put("tel", tel);
	           	JSONArray object =  (JSONArray) resBody.get("data");
	           	if(type == 1){
	            	goalData.put("MessageList", object.get(0));      		
	           	}else{
	           		goalData.put("MessageList", object); 
	           	}
	       
	           	
	           	return goalData;
	    } 
	    }
	        catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return null;
	}

}

