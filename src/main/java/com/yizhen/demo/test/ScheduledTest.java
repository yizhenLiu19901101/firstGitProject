package com.yizhen.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程
		Runnable runnableBook = new Runnable() {  
			public void run() {	
				synchronizeBook();  
				System.out.println("*************************"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"打印完成***************************");
			}  
		}; 
		Callable<String> callableBook = new Callable<String>() {
			public String call() throws Exception {
				synchronizeBook();  
				System.out.println("*************************"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"打印完成***************************");
			    return "success";
			}
		};
		//创建单线程执行器，ScheduledExecutorService,是基于线程池设计的定时任务类,每个调度任务都会分配到线程池中的一个线程去执行,
		//也就是说,任务是并发执行,互不影响。需要注意,只有当调度任务来的时候,ScheduledExecutorService才会真正启动一个线程,其余时间
		//ScheduledExecutorService都是出于轮询任务的状态。
		ScheduledExecutorService serviceBook = Executors.newSingleThreadScheduledExecutor();  
		//执行调度，方式有两种,ScheduleAtFixedRate 每次执行时间为上一次任务开始起向后推一个时间间隔，
		//即每次执行时间为 :initialDelay, initialDelay+period, initialDelay+2*period, …；
		//ScheduleWithFixedDelay 每次执行时间为上一次任务结束起向后推一个时间间隔，即每次执行时间为：initialDelay, 
		//initialDelay+executeTime+delay, initialDelay+2*executeTime+2*delayScheduleAtFixedRate 是基于固定时间间隔进行任务调度，
		//ScheduleWithFixedDelay 取决于每次任务执行的时间长短，是基于不固定时间间隔进行任务调度。
//		Future<String> result = serviceBook.submit(callableBook);
//		System.out.println(result.get());
		serviceBook.scheduleAtFixedRate(runnableBook, 5, 10, TimeUnit.SECONDS); 
	}
	
	public static void synchronizeBook() {
		System.out.println("--11111--");
	}

}
