package com.yizhen.demo.designPattern.createType.builder;

/**
 * 导演
 * @author liuyizhen
 *
 */
public class Director {
	/**
     * 持有当前需要使用的建造器对象
     */
    private Builder builder;
    /**
     * 构造方法，传入建造器对象
     * @param builder 建造器对象
     */
    public Director(Builder builder){
        this.builder = builder;
    }
    /**
     * 产品构造方法，负责调用各个零件的建造方法
     */
    public void construct(){
        //起名字
        builder.buildName();
        //写编号
        builder.buildCode();
    }
}
