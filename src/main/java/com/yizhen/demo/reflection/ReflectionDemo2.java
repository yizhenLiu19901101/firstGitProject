package com.yizhen.demo.reflection;

/**
 * 实例化class对象
 * @author liuyizhen
 *
 */
public class ReflectionDemo2 {
	 public static void main(String[] args) throws Exception {
	        Class<?> class1 = null;
	        Class<?> class2 = null;
	        Class<?> class3 = null;
	        // 一般采用这种形式
	        class1 = Class.forName("com.yizhen.demo.reflection.ReflectionDemo2");
	        class2 = new ReflectionDemo2().getClass();
	        class3 = ReflectionDemo2.class;
	        System.out.println("类名称   " + class1.getName());
	        System.out.println("类名称   " + class2.getName());
	        System.out.println("类名称   " + class3.getName());
	    }
}
