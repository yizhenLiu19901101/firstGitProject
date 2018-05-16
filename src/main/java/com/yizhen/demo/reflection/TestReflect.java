package com.yizhen.demo.reflection;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//定义项目接口
interface Subject {
    public String say(String name, int age);
}

//定义真实项目
class RealSubject implements Subject {
    public String say(String name, int age) {
        return name + " && " + age;
    }
}

//代理类
class MyInvocationHandler implements InvocationHandler {
    
	private Object obj = null;
    
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	Object temp = method.invoke(this.obj, args);
        return temp;
    }
}
/**
* 在java中有三种类类加载器。
* 
* 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
* 
* 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jrelibext目录中的类
* 
* 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
* 
* 如果想要完成动态代理，首先需要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
* 
* @author liuyizhen
* 
*/
public class TestReflect {
    public static void main(String[] args) throws Exception {
    	//实例化代理类
        MyInvocationHandler demo = new MyInvocationHandler();
        //绑定目标类
        Subject sub = (Subject) demo.bind(new RealSubject());
        //调用目标方法
        String info = sub.say("Rollen", 20);        
        System.out.println(info);
    }
}