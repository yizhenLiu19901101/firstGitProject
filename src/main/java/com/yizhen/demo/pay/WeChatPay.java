package com.yizhen.demo.pay;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom2.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.yizhen.demo.utils.PayCommonUtil;

@Controller
@RequestMapping(value = "${appPath}/wechatPay")
public class WeChatPay {
	
	public static final String MCHID = "*******";
	public static final String APPSECRET = "*******";
	public static final String APPID = "*******";
	public static final String APIKEY = "*******";
	public static void main(String[] args) throws Exception {			
	InetAddress inetAddress =  InetAddress.getLocalHost();
    
	System.out.println("订单号 : " + UUID.randomUUID().toString().replaceAll("-", ""));
	System.out.println("本机IP  " + inetAddress.getLocalHost().getHostAddress());
	getOrder();
}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseBody
	public static String getOrder() {
		String result = null;
		Map<String, String> map = null;
		map = weixinPrePay(UUID.randomUUID().toString().replaceAll("-", ""),"192.168.1.98");		
		System.out.println("result1 = "+ map);
		if(map.get("result_code").equals("SUCCESS")) {
			System.out.println("成功,prePayId = " + map.get("prepay_id"));
			result = createSignAgain(map);
			System.out.println("result2 = " + result);
	    }else {
	    	System.out.println("失败！");
	    }
		return result;
	}
	
	
	
	public static Map<String, String> weixinPrePay(String sn,String ip) {  
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();  
        parameterMap.put("appid", APPID);  
        parameterMap.put("mch_id", MCHID);  
        parameterMap.put("nonce_str", PayCommonUtil.getRandomString(32));  
        parameterMap.put("body",  "微信测试");  
        parameterMap.put("out_trade_no", sn);  
        parameterMap.put("fee_type", "CNY");  
        parameterMap.put("total_fee", "1");  
        parameterMap.put("spbill_create_ip", ip);  
        parameterMap.put("notify_url", "https://zaowushaonian.com/langduzhe/app/wechatPay/alipayNotify");  
        parameterMap.put("trade_type", "APP");    
        String sign = PayCommonUtil.createSign("UTF-8", parameterMap);    
        parameterMap.put("sign", sign);  
        String requestXML = PayCommonUtil.getRequestXml(parameterMap);  
        System.out.println(requestXML);  
        String result = PayCommonUtil.httpsRequest(  "https://api.mch.weixin.qq.com/pay/unifiedorder", "POST",  requestXML);  
        System.out.println(result);  
        Map<String, String> map = null;  
        try {  
            map = PayCommonUtil.doXMLParse(result);  
        } catch (JDOMException e) {  
            e.printStackTrace();  
        } catch (IOException e) {   
            e.printStackTrace();  
        }  
        return map;  
    }
	
	public static String createSignAgain(Map<String,String> map) {     
		JSONObject jsonObject = new JSONObject();  
		SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();  
		parameterMap.put("appid", APPID);  
		parameterMap.put("partnerid", MCHID);  
		parameterMap.put("prepayid", map.get("prepay_id"));  
		parameterMap.put("package", "Sign=WXPay");  
		parameterMap.put("noncestr", PayCommonUtil.getRandomString(32));  
		parameterMap.put("timestamp", System.currentTimeMillis());  
		String sign = PayCommonUtil.createSign("UTF-8", parameterMap);  
		parameterMap.put("sign", sign);  
		jsonObject.put("parameterMap",parameterMap);  
		return jsonObject.toString();  
    }
	
	
	@RequestMapping(value = "/alipayNotify", method = RequestMethod.POST)
	@ResponseBody
	public void alipayNotify(HttpServletRequest request,HttpServletResponse response){
		try {
			InputStream inStream = request.getInputStream();  
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
			byte[] buffer = new byte[1024];
			int len = 0;  
			while ((len = inStream.read(buffer)) != -1) {  
			    outSteam.write(buffer, 0, len);  
			}  
			System.out.println("********************付款成功**************");  
			outSteam.close();  
			inStream.close();  
			String result = new String(outSteam.toByteArray(), "utf-8");// 获取微信调用我们notify_url的返回信息  
			Map<Object, Object> map = PayCommonUtil.doXMLParse(result);    
			if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {  
			    System.out.println("异步回调成功！"); 
			}
		} catch (UnsupportedEncodingException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}  	   
	}
	
	public boolean verifyWeixinNotify(Map<Object, Object> map) {  
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();  
        String sign = (String) map.get("sign");  
        for (Object keyValue : map.keySet()) {  
            if(!keyValue.toString().equals("sign")){  
                parameterMap.put(keyValue.toString(), map.get(keyValue));  
            }       
        }  
        String createSign = PayCommonUtil.createSign("UTF-8", parameterMap);  
        if(createSign.equals(sign)){  
            return true;  
        }else{  
            return false;  
        }       
    } 
}

