package com.yizhen.demo.designPattern.behavierType.strategy;

/**
 * 具体策略角色
 * @author liuyizhen
 *
 */
public class PrimaryStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		 System.out.println("对于初级会员的没有折扣");
	     return booksPrice;
	}

}
