package com.yizhen.demo.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import com.yizhen.demo.jorkAndJoin.CountTask;

public class ForkJoinTest {
	
	public static void main(String[] args){
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		//生成计算任务,计算1-4的结果
		CountTask countTask = new CountTask(1,4);
		long start = System.currentTimeMillis();
		
		Future<Integer>  result = (Future<Integer>) forkJoinPool.submit(countTask);
		long end = System.currentTimeMillis();
		try {
			System.out.println("time used : " + (end - start) + "ms ,result = " + result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}	
	}
}
