package com.yizhen.demo.entities;

import java.io.Serializable;

public class User implements Serializable{
    //用户ID
	private String id;
    //雇员名
	private String employeeName;
	//性别
	private String gender;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", employeeName=" + employeeName + ", gender=" + gender + "]";
	}
}
