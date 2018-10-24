package com.yizhen.demo.designPattern.createType.prototype;


import lombok.Data;

/**
 * 形状对象
 * @author  milo
 */
@Data
public abstract class ShapeObject implements Cloneable {
    /**
     * id
     */
	private String id;
    /**
     * 类型
     */
	protected String type;

    /**
     * 画
     */
	abstract void draw();

    @Override
    public Object clone() {
       Object clone = null;
       try {
           clone = super.clone();
      } catch (CloneNotSupportedException e) {
           e.printStackTrace();
      }
      return clone;
   }
}
