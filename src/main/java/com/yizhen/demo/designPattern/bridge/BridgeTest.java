package com.yizhen.demo.designPattern.bridge;

/**
 * Bridge 模式把两个角色之间的继承关系改为了耦合的关系，从而使这两者可以从容自若的各自独立的变化，这也是Bridge模式的本意
 * 客户角色
 * @author liuyizhen
 *
 */  
public class BridgeTest {
	public static void main(String[] args){  
	    AbstractRoad speedWay = new SpeedWay();  
	    //耦合关系
	    speedWay.aCar = new Car();  
	    speedWay.run();  
	    AbstractRoad street = new Street();  
	    //耦合关系
	    street.aCar = new Bus();  
	    street.run();  
	}  
}
