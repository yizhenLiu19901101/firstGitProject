package com.yizhen.demo.designPattern.strategy;

/**
 * 具体策略角色
 * @author liuyizhen
 *
 */
public class InterMediateStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
	    return booksPrice * 0.9;
	}

}
