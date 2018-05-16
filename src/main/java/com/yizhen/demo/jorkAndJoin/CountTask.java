package com.yizhen.demo.jorkAndJoin;

import java.util.concurrent.RecursiveTask;



public class CountTask extends RecursiveTask<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//阈值
	private static final int THRESHOLD = 2;
	private int start;
	private int end;
	
	/**
	 * 构造器方法
	 * @param start
	 * @param end
	 */
	public CountTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}



	@Override
	protected Integer compute() {
		int sum = 0;
		//如果任务足够小就计算任务
		boolean canCompute = (end - start) <= THRESHOLD;
		if(canCompute) {
		    for(int i = start;i <= end;i++) {
		    	    sum += i;
		    }
		}else {
			//如果任务大于阈值，就分裂成两个阈值计算
			int middle = (end - start)/2;
			CountTask leftTask = new CountTask(start,middle);
			CountTask rightTask = new CountTask(middle + 1,end);
			//执行子任务
			leftTask.fork();
			rightTask.fork();
			//等到子任务执行完，并得到其结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			sum = leftResult + rightResult;			
		}		
		return sum;
	}
}
