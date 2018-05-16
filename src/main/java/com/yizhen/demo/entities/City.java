package com.yizhen.demo.entities;

import java.io.Serializable;

public class City implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//id
	private String id;
	//城市名称
	private String cityName;
	//城市编码
	private String cityCode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", cityCode=" + cityCode + "]";
	}
	
	
}
