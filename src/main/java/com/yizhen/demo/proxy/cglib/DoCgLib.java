package com.yizhen.demo.proxy.cglib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jdk动态代理是由Java内部的反射机制来实现的，cglib动态代理底层则是借助asm来实现的。总的来说，反射机制在生成类的过程中比较高效，
 * 而asm在生成类之后的相关执行过程中比较高效（可以通过将asm生成的类进行缓存，这样解决asm生成类过程低效问题）。还有一点必须注意：jdk动态代理的应用前提，
 * 必须是目标类基于统一的接口。如果没有上述前提，jdk动态代理不能应用。由此可以看出，jdk动态代理有一定的局限性，cglib这种第三方类库实现的动态代理应用更加广泛，
 * 且在效率上更有优势。。 
 * @author Administrator
 *
 */

public class DoCgLib {
	
	public static void main(String[] args) {  
		Logger logger = LoggerFactory.getLogger(DoCgLib.class);
		CglibProxy proxy = new CglibProxy();  
	    //通过生成子类的方式创建代理类  
	    SayHello proxyImp = (SayHello)proxy.getProxy(SayHello.class);  
	    proxyImp.say();
	    logger.info("**************");
	    proxyImp.sayHi();
	    
    }  
}  