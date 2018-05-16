package com.yizhen.demo.designPattern.observer;

public class ConcreteObserver extends Observer {

    private String observerState;
    private String name;
    private ConcreteSubject subject;     
    
    @Override
	public void update(){ 
	  observerState = subject.getSubjectState();
      System.out.println("The observer's state of " + name +"is" + observerState);
	}
    
	public ConcreteObserver(ConcreteSubject subject, String name)
    {
        this.subject = subject;
        this.name = name;
    }

	      


}
