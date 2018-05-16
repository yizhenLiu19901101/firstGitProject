package com.yizhen.demo.designPattern.observer;

/**
 * 
 *   观察者模型，有时被称作发布/订阅模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 *   这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己，相关角色：
 * 　 1、抽象主题（Subject）：它把所有观察者对象的引用保存到一个聚集里，每个主题都可以有任何数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象。
 *    2、具体主题（ConcreteSubject）：将有关状态存入具体观察者对象；在具体主题内部状态改变时，给所有登记过的观察者发出通知。 
 *　  3、 抽象观察者（Observer）：为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
 *　  4、 具体观察者（ConcreteObserver）：实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题状态协调。
 *   Spring的事件驱动模型使用的就是观察者模型
 *   @author liuyizhen
 *
 */
public class ObserverTest {
	public static void main(String[] args) {
		//具体主题角色通常用具体自来来实现
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver(subject, "Observer A"));
        subject.attach(new ConcreteObserver(subject, "Observer B"));
        subject.attach(new ConcreteObserver(subject, "Observer C"));
        subject.setSubjectState("Ready");
        subject.notify();
	}
}
