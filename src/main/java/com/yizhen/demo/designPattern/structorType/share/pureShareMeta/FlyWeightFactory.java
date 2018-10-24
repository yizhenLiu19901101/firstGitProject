package com.yizhen.demo.designPattern.structorType.share.pureShareMeta;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {
    private Map<Character,FlyWeight> files = new HashMap<Character,FlyWeight>();
    
    public FlyWeight factory(Character state){
        //先从缓存中查找对象
    	FlyWeight fly = files.get(state);
        if(fly == null){
            //如果对象不存在则创建一个新的Flyweight对象
            fly = new ConcreteFlyWeight(state);
            //把这个新的Flyweight对象添加到缓存中
            files.put(state, fly);
        }
        return fly;
    }
}