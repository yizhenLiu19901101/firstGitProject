package com.yizhen.demo.designPattern.structorType.decorator;
/**
 * 装饰模式又名包装(Wrapper)模式。装饰模式以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案
 * 装饰模式对客户端的透明性要求程序不要声明一个ConcreteComponent类型的变量，而应当声明一个Component类型的变量。
 * 抽象构件(Component)角色：给出一个抽象接口，以规范准备接收附加责任的对象。
 * 具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类。
   装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。
   具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。
   装饰模式有透明和半透明两种，这两种的区别就在于装饰角色的接口与抽象构件角色的接口是否完全一致。
   透明的装饰模式也就是理想的装饰模式，要求具体构件角色、装饰角色的接口与抽象构件角色的接口完全一致。
   相反，如果装饰角色的接口与抽象构件角色接口不一致，也就是说装饰角色的接口比抽象构件角色的接口宽的话，
   装饰角色实际上已经成了一个适配器角色，这种装饰模式也是可以接受的，称为“半透明”的装饰模式
 * @author liuyizhen
 *
 */
public class DecoratorTest {
    public static void main(String[] args) {
        //装饰模式,声明一个抽象构建类型的变量
    	    TheGreatestSage sage = new Monkey();
        TheGreatestSage fish = new Fish(new Bird(sage));
      
        fish.move();
        System.out.println("------");
        //半透明的装饰模式，声明一个具体装饰类型的变量，改变接口的方法（新增新的方法），它最可以体现扩展对象的功能
        Bird bird = new Bird(sage);
        bird.move(); 
        bird.fly();
    }
}
