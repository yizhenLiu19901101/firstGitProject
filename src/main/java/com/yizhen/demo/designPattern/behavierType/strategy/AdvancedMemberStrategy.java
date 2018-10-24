package com.yizhen.demo.designPattern.behavierType.strategy;

/**
 * 具体策略
 * @author liuyizhen
 *
 */
public class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
