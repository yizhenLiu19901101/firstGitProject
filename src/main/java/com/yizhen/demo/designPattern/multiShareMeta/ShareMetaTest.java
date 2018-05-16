package com.yizhen.demo.designPattern.multiShareMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * String 创建的时候使用该例子
 * 享元模式采用一个共享来避免大量拥有相同内容对象的开销。这种开销最常见、最直观的就是内存的损耗。享元对象能做到共享的关键是区分内蕴状态(Internal State)和外蕴状态(External State)。
 *　一个内蕴状态是存储在享元对象内部的，并且是不会随环境的改变而有所不同。因此，一个享元可以具有内蕴状态并可以共享。
 *　一个外蕴状态是随环境的改变而改变的、不可以共享的。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。外蕴状态不可以影响享元对象的内蕴状态，它们是相互独立的。
 *　享元模式可以分成单纯享元模式和复合享元模式两种形式。
 *  　1、抽象享元(Flyweight)角色 ：给出一个抽象接口，以规定出所有具体享元角色需要实现的方法。
 *　  2、具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定出的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。
 *    3、享元工厂(FlyweightFactory)角色 ：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。当一个客户端对象调用一个享元对象
 * @author liuyizhen
 *
 */
public class ShareMetaTest {
	 public static void main(String[] args) {
	 	List<Character> compositeState = new ArrayList<Character>();
        compositeState.add('a');
        compositeState.add('b');
        compositeState.add('c');
        compositeState.add('a');
        compositeState.add('b');
        
        FlyWeightFactory flyFactory = new FlyWeightFactory();
        FlyWeight compositeFly1 = flyFactory.factory(compositeState);
        FlyWeight compositeFly2 = flyFactory.factory(compositeState);
        compositeFly1.operation("Composite Call");
        
        System.out.println("---------------------------------");        
        System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));
        
        Character state = 'a';
        FlyWeight fly1 = flyFactory.factory(state);
        FlyWeight fly2 = flyFactory.factory(state);
        System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));
	}
}
