package com.yizhen.demo.designPattern.behavierType.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 对象
 * @author liuyizhen
 *
 */
class ObjectStruture {    
    public static List<Element> getList(){    
        List<Element> list = new ArrayList<Element>();    
        Random ran = new Random();    
        for(int i = 0; i < 10; i++){    
            int a = ran.nextInt(100);    
            if(a > 50){    
                list.add(new ConcreteElement1());    
            }else{    
                list.add(new ConcreteElement2());    
            }    
        }    
        return list;    
    }    
}  