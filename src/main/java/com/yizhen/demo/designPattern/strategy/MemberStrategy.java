package com.yizhen.demo.designPattern.strategy;

/**
 * 抽象策略
 * @author liuyizhen
 *
 */
public interface MemberStrategy {

    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);
}
