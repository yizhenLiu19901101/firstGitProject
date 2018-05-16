package com.yizhen.demo.pay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

@Controller
@RequestMapping(value = "${appPath}/wechatPay")
public class AliPay {
	private static final String APP_ID = "***"; 	           
	private static final String APP_PRIVATE_KEY = "***";
	private static final String CHARSET = "utf-8";
	private static final String ALIPAY_PUBLIC_KEY = "***";
	private static final String SERVER_URL = "https://openapi.alipay.com/gateway.do";
	private static final int ALIPAY_ORDER_STATUS = 4;

	private String getAliPayOrderNo(String outTradeNo,String total){
		String orderNo="";
		AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL,APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
		
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("this is a test trade");
		model.setSubject("***");
		model.setOutTradeNo(outTradeNo);
		model.setTimeoutExpress("30m");
		model.setTotalAmount(total);
		model.setProductCode("QUICK_MSECURITY_PAY");

		request.setBizModel(model);
		request.setNotifyUrl("***");
		try {
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			orderNo=response.getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return orderNo;
	}

	@RequestMapping(value = "/alipayNotify", method = RequestMethod.POST)
	@ResponseBody
	public void alipayNotify(HttpServletRequest request){
		try{
			Map<String,String> params = new HashMap<String,String>();
			Map<String, String[]> requestParams = request.getParameterMap();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
				}
				/*System.out.println(name+":"+valueStr);
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");*/
				params.put(name, valueStr);
			}
			boolean flag = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, "utf-8", "RSA2");
			/*System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("params="+params);*/
			System.out.println("**************支付结果："+flag+"**************");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
