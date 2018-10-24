package com.yizhen.demo.designPattern.behavierType.mediate;

/**
 * 具体中介类
 * @author liuyizhen
 *
 */
public class ConcreteMediator extends Mediator {
    ColleagueA collA;
    ColleagueB collB;
  
    public ColleagueA getCollA() {
        return collA;
    }
  
    public void setCollA(ColleagueA collA) {
        this.collA = collA;
    }
 
     public ColleagueB getCollB() {
         return collB;
     }
 
     public void setCollB(ColleagueB collB) {
         this.collB = collB;
     }
 
     @Override
     public void contact(String content, Colleague coll) {
         if (coll == collA) {
             collB.getMessage(content);
         } else {
             collA.getMessage(content);
         }
     }
 }
