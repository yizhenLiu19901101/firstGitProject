package com.yizhen.demo.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 动态数据源-抽象路由数据源的实现类
 * @author liuyizhen
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {  
    @Override  
    protected Object determineCurrentLookupKey() {  
        return CustomerContextHolder.getCustomerType();  
    }  
} 
