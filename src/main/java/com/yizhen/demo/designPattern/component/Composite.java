package com.yizhen.demo.designPattern.component;

import java.util.ArrayList;
import java.util.List;

//组合类
class Composite extends Component{
  private List<Component> child = new ArrayList<Component>();
    
   public Composite(String s) {
       super(s);
   }

   @Override
   public void add(Component c) {
       child.add(c);
       
   }

   @Override
   public void foreach() {
       System.out.println("节点名:\t"+name);
       for (Component c : child) {
           c.foreach();
       }
   }

   @Override
   public void remove(Component c) {
       child.remove(c);
   }
    
}