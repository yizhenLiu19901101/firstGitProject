package com.yizhen.demo.reflection;

import java.lang.reflect.Method;


/**
 * java基本数据类型：数字(byte(多用于表达内存),short,int,long)、浮点数(double、float)、布尔(boolean)、字符（char）
 * 得到一个类的完成名称
 * @author liuyizhen
 *
 */
public class ReflectionDemo1 { 
	public static void main(String[] args) throws Exception {
	    ReflectionDemo1 testReflect = new ReflectionDemo1();
        System.out.println(testReflect.getClass().getName());
        System.out.println("----------------------------");
        ReflectionDemo1 testReflect2 = ReflectionDemo1.class.newInstance();
        testReflect2.doThings("lily");
        System.out.println("----------------------------");
        Class<?> testReflect3 = Class.forName("com.yizhen.demo.reflection.ReflectionDemo1");
        Method method = testReflect3.getMethod("doThings",String.class);
        method.invoke(testReflect3.newInstance(),"jack");
        Class<?>[] types = method.getParameterTypes();
        for(Class<?> type:types) {
        	System.out.println(type.toString());
        }
        Class<?> type = method.getReturnType();
        System.out.println(type.toString());
	}
	
	public void doThings(String who) {
	    System.out.println("do things ......");
	}
}
