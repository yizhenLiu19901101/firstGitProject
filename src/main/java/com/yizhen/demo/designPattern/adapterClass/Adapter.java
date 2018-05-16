package com.yizhen.demo.designPattern.adapterClass;

/**
 * 适配器类
 * @author liuyizhen
 *
 */
public class Adapter extends Adaptee implements Target {
    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        System.out.println("sampleOperation2...");
    }

}
