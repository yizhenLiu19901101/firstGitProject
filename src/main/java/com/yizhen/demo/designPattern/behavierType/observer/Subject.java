package com.yizhen.demo.designPattern.behavierType.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题
 * @author liuyizhen
 *
 */
public abstract class Subject
{
    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer)
    {    
    		observers.add(observer);
    }

    public void detach(Observer observer)
    {
        observers.remove(observer);
    }
  
    /**
     * 类似于广播
     */
    public void notice()
    {
        for (Observer observer:observers)
        {
        		observer.update();
        }
    }
}
