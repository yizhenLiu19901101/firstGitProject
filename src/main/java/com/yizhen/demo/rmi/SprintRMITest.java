package com.yizhen.demo.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprintRMITest {

	public static void main(String[] args) throws RemoteException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-rmi.xml");
	    SpringStudentService sprintStudentService=(SpringStudentService) ctx.getBean("getStudentService");
		List<Student> list = sprintStudentService.getList();
		for (Student s : list) {
		    System.out.println("姓名："+s.getName()+",年龄："+s.getAge());
		}
	}
}
