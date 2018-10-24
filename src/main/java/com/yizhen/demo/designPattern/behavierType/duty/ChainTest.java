package com.yizhen.demo.designPattern.behavierType.duty;

/**
 * 责任链模式
 * 主要解决职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，
 * 无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了
 * @author liuyizhen
 *
 */
public class ChainTest {

	public static void main(String[] args) {
		
         ProjectHandler projectHandler =new ProjectHandler();
         
         DeptHandler deptHandler =new DeptHandler();
         
         GeneralHandler generalHandler =new GeneralHandler();
         
         projectHandler.setNextHandler(deptHandler);
         
         deptHandler.setNextHandler(generalHandler);
         
         //处理流程
         projectHandler.doHandler("lwx", 450);
         
         projectHandler.doHandler("lwx", 600);
         
         projectHandler.doHandler("zy", 600);
         
         projectHandler.doHandler("zy", 1500);
         
         projectHandler.doHandler("lwxzy", 1500);
     
	}
}
