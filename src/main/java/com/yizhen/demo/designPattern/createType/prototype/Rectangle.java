package com.yizhen.demo.designPattern.createType.prototype;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 三角形类
 * @author  milo
 */
@Data
public class Rectangle extends ShapeObject{
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(Rectangle.class);
    private String label;
    /**
     * 无参构造器
      */
    public Rectangle()
     {
         type = "Rectangle";
	 }

    /**
     * 有参构造器
     * @param label
     */
     public Rectangle(String label) {
         this.label = label;
         type = "Rectangle";
     }

    @Override
     public void draw() {
         logger.info("Inside Rectangle::draw() method.");
     }
}
