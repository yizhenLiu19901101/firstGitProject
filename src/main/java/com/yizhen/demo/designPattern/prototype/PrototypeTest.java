package com.yizhen.demo.designPattern.prototype;

public class PrototypeTest {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();  
        for(int i = 0; i < 3; i++){  
        	Rectangle clonecp = (Rectangle) rectangle.clone();  
            clonecp.draw();  
        } 
	}
}
