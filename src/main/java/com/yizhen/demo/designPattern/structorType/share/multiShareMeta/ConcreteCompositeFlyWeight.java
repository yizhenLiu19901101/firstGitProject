package com.yizhen.demo.designPattern.structorType.share.multiShareMeta;

import java.util.HashMap;
import java.util.Map;

public class ConcreteCompositeFlyWeight implements FlyWeight {
    
    private Map<Character,FlyWeight> files = new HashMap<Character,FlyWeight>();
    
    /**
     * 增加一个新的单纯享元对象到聚集中
     */
    public void add(Character key , FlyWeight fly){
        files.put(key,fly);
    }
    
    /**
     * 外蕴状态作为参数传入到方法中
     */
    @Override
    public void operation(String state) {
    	FlyWeight fly = null;
        for(Object o : files.keySet()){
            fly = files.get(o);
            fly.operation(state);
        }
        
    }

}