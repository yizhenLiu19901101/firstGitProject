package com.yizhen.demo.designPattern.whiteIterator;

public class IteratorTest {
	public void operation(){  
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};  
        //创建聚合对象  
        IteratorAggregate agg = new ConcreateIteratorAggregate(objArray);  
        //循环输出聚合对象中的值  
        Iterator it = agg.createIterator();  
        while(!it.isDone()){  
            System.out.println(it.currentItem());  
            it.next();  
        }  
    }
		
	public static void main(String[] args) {            
		IteratorTest iteratorTest = new IteratorTest();  
		iteratorTest.operation();
	}

}
