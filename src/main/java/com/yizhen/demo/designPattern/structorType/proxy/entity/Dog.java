package com.yizhen.demo.designPattern.structorType.proxy.entity;

/**
 * 狗
 * @author  milo
 */
public class Dog implements  Animal{
    @Override
    public void eat(String s) {
        System.out.println("啃"+s);
    }
}
