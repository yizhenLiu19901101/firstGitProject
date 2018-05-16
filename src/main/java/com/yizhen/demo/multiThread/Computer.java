package com.yizhen.demo.multiThread;

/**
 * 生产-消费者模型
 * @author Administrator
 *
 */
public class Computer {
	 	// 表示仓库中库存数
	 	private int number = 10;
	 	// 往仓库里存放电脑
	 	public synchronized void put(String name) {
	 		if (number >= 10) {
	 			try {
					this.wait();
	 			} catch (Exception e) {
	 				e.printStackTrace();
	 			}
	 			System.out.println(Thread.currentThread().getName()+ "：存放等待---仓库库存足够");
	 			return;
	 		}
	 		number += 1;
	 		System.out.println(Thread.currentThread().getName() + "存放了一台" + name + "电脑,目前库存电脑总数为:" + number);
	 		// 唤醒所有等待的线程(线程在执行wait()方法后，会释放对象同步锁)
	 		notifyAll();
	 	}
	 	// 向仓库里取出电脑
	 	public synchronized void get(String name) {
	 		if (number <= 0) {
	 			try {
	 			this.wait();
	 			} catch (Exception e) {
	 				e.printStackTrace();
	 			}
	 		System.out.println(Thread.currentThread().getName()
	 					+ ": 取电脑受阻-因为库存余数为0");
	 			return;
	 		}
	 		number -= 1;
	 		System.out.println(Thread.currentThread().getName() + "取出了一台" + name + "电脑,目前电脑总数为:" + number);
	 		notifyAll();
	 	}
	 	
		public static void main(String[] args) {
	 		Computer computer = new Computer();
	 		// 构造生产者
	 		Producer producer = new Producer(computer);
	 		// 构造消费者
	 	    Consumer consumer = new Consumer(computer);
	 		// 创建生产者两个线程
		    Thread t1 = new Thread(producer);
	 		t1.setName("主生产者");
	 		Thread t2 = new Thread(producer);
			t2.setName("辅助生产者");
	 	    // 创建消费者两个线程
	 	    Thread t3 = new Thread(consumer);
	 		t3.setName("主消费者");
	 		Thread t4 = new Thread(consumer);
	 		t4.setName("辅助消费者");
	 		// 启动线程
	 		t1.start();
	 	    t2.start();
	 		t3.start();
	 		t4.start();
	 	}
	 }
	 
	 /**
	  * 消费者线程
	  * @author Jerry Wang
	  *
	  */
	 class Consumer implements Runnable {
	 	Computer computer;
	 	public Consumer(Computer computer) {
	 		this.computer = computer;
	 	}
	 	
	 	public void run() {
	 		while(true){
	 			computer.get("联想");
	 		}
	 	}
	 }
	 
	 /**
	  * 生产者线程
	  * @author Jerry Wang
	  *
	  */
	 class Producer implements Runnable {
	 	Computer computer;
	 	public Producer(Computer computer) {
	 		this.computer = computer;
	 	}
	 	public void run() {
	 		while(true){
	 			this.computer.put("联想");
	 		}
	 	}
	 }
