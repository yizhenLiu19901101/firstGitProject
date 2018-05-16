package com.yizhen.demo.socket;

public class SayHelloServiceImpl implements SayHellloService {

	@Override
	public String sayHello(String helloArg) {
		if(helloArg.equals("hello")) {
			return "hello";
		}else {
			return "bye bye";
		}
	}

}
