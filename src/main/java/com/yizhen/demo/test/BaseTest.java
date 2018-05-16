package com.yizhen.demo.test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;


public class BaseTest {
	public static void main(String[] args) throws ParseException {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		//lamda表达式
		features.forEach(n -> System.out.println(n));
		System.out.println("-----------------------");
	    features.forEach(System.out::println);
//		
//		int a = 44311210;
//		double b = 0;
//		if(a >= 10000) {
//		    b = a/10000.00;
//		    DecimalFormat df = new DecimalFormat("###.##");
//		    System.out.println("b = " + df.format(b)+"万步");
//		}else {
//			System.out.println("b = " + a + "步");
//		}
	//	SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	//	SimpleDateFormat sdf2 = new SimpleDateFormat( "yyyyMMddHHmmss" );
	//  String b = "2017-01-16T09:15:25.24".replace("T", " ");
	//	String a = b.substring(0,b.indexOf("."));
	//	System.out.println("a = "+a);
	//	Date date = sdf.parse(a);
	//	System.out.println("date = "+date);
	//	String c = sdf2.format(date);
	//	System.out.println("c = " + c);
		
	//	Calendar cal = Calendar.getInstance(); 
	//	Date date = cal.getTime();
	//	//  2016/05/05-01:01:34:364
	//	System.out.println("---" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
	////	
	//    String dataId = UUID.randomUUID().toString();
	//	System.out.println(" dataId = " + dataId + " dataHashCode = " + dataId.hashCode());
	//	System.out.println("*********");
	//	System.out.println(Math.abs(-4)%3);
	//	HashMap<String,Object> hashMap = new HashMap<String,Object>();
	//	hashMap.put("code", "111");
	//	hashMap.put("code", "222");
	//	System.out.println(hashMap.get("code"));
	//	System.out.println("********");
	//  System.out.println("当前时间 ：" + System.currentTimeMillis()/1000);
//		DecimalFormat df = new DecimalFormat("##0.00");
//		double f =77.50;
//		int c;
//		double  a= (1*100)/(4.00);
//		double b = Math.round(a*100)/100.0;
//		c = (int) (f/b);
//		System.out.println("c = " + c);
	    System.out.println("hello , xue 111");
	    
	}
}
