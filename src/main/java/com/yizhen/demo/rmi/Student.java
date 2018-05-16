package com.yizhen.demo.rmi;

import java.io.Serializable;
public class Student implements Serializable {
   /**
	 * 
	 */
    private static final long serialVersionUID = 786173990453135862L;
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }     
 }