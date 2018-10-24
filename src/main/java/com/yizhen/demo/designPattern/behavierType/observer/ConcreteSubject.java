package com.yizhen.demo.designPattern.behavierType.observer;

/**
 * 具体主题
 * @author liuyizhen
 *
 */
public class ConcreteSubject extends Subject{
    
	private String subjectState;
	
    public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
	}
}
