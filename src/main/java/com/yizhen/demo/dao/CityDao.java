package com.yizhen.demo.dao;

import com.yizhen.demo.entities.City;

public interface CityDao {
    /*
     * 查询城市
     */
	public City selectCity(String id);
}
