package com.yizhen.demo.designPattern.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 外观模式（Facade）,他隐藏了系统的复杂性，并向客户端提供了一个可以访问系统的接口。
 * 这种类型的设计模式属于结构性模式。为子系统中的一组接口提供了一个统一的访问接口，这个接口使得子系统更容易被访问或者使用
 * 该模式就是把一些复杂的流程封装成一个接口供给外部用户更简单的使用。这个模式中，设计到3个角色。
 *　1）.门面角色：外观模式的核心。它被客户角色调用，它熟悉子系统的功能。内部根据客户角色的需求预定了几种功能的组合。
 *　2）.子系统角色:实现了子系统的功能。它对客户角色和Facade时未知的。它内部可以有系统内的相互交互，也可以由供外界调用的接口。
 *  3）.客户角色:通过调用Facede来完成要实现的功能。
 * @author liuyizhen
 *
 */
public class FacadeTest {

	public static void main(String[] args) {
		final Logger LOGGER = LoggerFactory.getLogger(FacadeTest.class);	
		Computer computer = new Computer();
        computer.start();
        LOGGER.info("=================");
        computer.shutDown();
	}

}
