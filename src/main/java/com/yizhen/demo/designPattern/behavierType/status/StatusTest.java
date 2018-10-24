package com.yizhen.demo.designPattern.behavierType.status;

/**
 * 
 * @author Administrator
 *
 */
public class StatusTest {

	public static void main(String[] args) {
		//创建状态
        State state = new ConcreteStateA();
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        context.setState(state);
        //请求
        context.request("testA");
        context.request("testB");
	}

}
