package com.yizhen.demo.designPattern.behavierType.mediate;

/**
 * 同事类
 * @author liuyizhen
 *
 */
public class Colleague {
	protected String name;
	protected Mediator mediator;
	 
    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
