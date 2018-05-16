package com.yizhen.demo.reflection;

import java.lang.reflect.Field;

/**
 * 操作一个类的属性
 * @author liuyizhen
 *
 */
public class ReflectionDemo8 {
    @SuppressWarnings("unused")
	private String proprety = null;
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.yizhen.demo.reflection.ReflectionDemo8");
        Object obj = clazz.newInstance();
        //可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        System.out.println(field.isAccessible());
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));
    }
}