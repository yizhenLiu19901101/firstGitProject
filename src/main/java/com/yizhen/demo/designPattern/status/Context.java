package com.yizhen.demo.designPattern.status;

public class Context {
	//持有一个State类型的对象实例
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    
    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
        if(sampleParameter.equals("testA")) {
            //转调state来处理
            state = new ConcreteStateA();  
            state.handle(sampleParameter);
        }else{
        	//转调state来处理
            state = new ConcreteStateB();  
            state.handle(sampleParameter);
        }
    }
}
