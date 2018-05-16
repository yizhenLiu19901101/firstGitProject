package com.yizhen.demo.designPattern.mediate;

/**
 * 用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * 中介者就是一个处于众多对象中间，并恰当地处理众多对象之间相互之间的联系的角色
 * @author liuyizhen
 *
 */
public class MediateTest {
	public static void main(String[] args) {
	    // 定义中介者
        ConcreteMediator mediator = new ConcreteMediator();
        // 定义具体同事类
        ColleagueA colleagueA = new ColleagueA("张三", mediator);
        ColleagueB colleagueB = new ColleagueB("李四", mediator);
         // 中介者知晓每一个具体的Colleague类
         mediator.setCollA(colleagueA);
         mediator.setCollB(colleagueB);
         colleagueA.contact("我是A，我要和同事B说说工作的事情");
         colleagueB.contact("我是B,我下午有时间,下午商量吧");
    }
}
