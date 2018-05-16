package com.yizhen.demo.designPattern.strategy;

/**
 * 策略模式属于对象的行为模式。其用意是针对一组算法，
 * 将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。
 * 策略模式使得算法可以在不影响到客户端的情况下发生变化
 * 
 * 　环境(Context)角色：持有一个Strategy的引用。
 *　 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
 *   具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
 * @author liuyizhen
 *
 */
public class StrategyTest {
	public static void main(String[] args) {
		//选择并创建需要使用的策略对象
        MemberStrategy strategy = new AdvancedMemberStrategy();
        //创建环境
        Price price = new Price(strategy);
        //计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
	}
}
