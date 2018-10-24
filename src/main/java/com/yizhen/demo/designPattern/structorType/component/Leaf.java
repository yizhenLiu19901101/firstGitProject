package com.yizhen.demo.designPattern.structorType.component;

//不在有根节点
class Leaf extends Component{ 
  public Leaf(String s) {
      super(s);         
  }
  @Override
  public void add(Component c) {
  } 
  @Override
  public void foreach() {
      System.out.println("tself name-->"+this.name);
  }
  @Override
  public void remove(Component c) {}
}
