package com.yizhen.demo.dao;

/**
 * 
 * @author liuyizhen
 *
 */
public class CustomerContextHolder {  
    public static final String DATA_SOURCE_A = "dataSource";  
    public static final String DATA_SOURCE_B = "dataSource2";  
    //线程局部变量，每个线程内都有一个该变量的副本
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
    public static void setCustomerType(String customerType) {  
        contextHolder.set(customerType);  
    }  
    public static String getCustomerType() {  
        return contextHolder.get();  
    }  
    public static void clearCustomerType() {  
        contextHolder.remove();  
    }  
} 
