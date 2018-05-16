package com.yizhen.demo.designPattern.prototype;



public class Rectangle extends ShapeObject{
	 public Rectangle(){
	     type = "Rectangle";
	 }

     @Override
     public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
     }
}
