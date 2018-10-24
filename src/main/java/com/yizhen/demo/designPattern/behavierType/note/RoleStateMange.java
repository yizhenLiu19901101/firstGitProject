package com.yizhen.demo.designPattern.behavierType.note;

/**
 * 管理者
 * @author liuyizhen
 *
 */
public class RoleStateMange {
	
    private RoleStateMemento memento;
    public RoleStateMemento getMemento() {
        return memento;
    }
    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }    
}