package com.yizhen.demo.rmi;

import java.util.ArrayList;
import java.util.List;

public class SpringStudentServiceImpl implements SpringStudentService {
    public List<Student> getList() {
	    List<Student> list=new ArrayList<Student>();
		Student s1=new Student();
		s1.setName("张三");
	    s1.setAge(15);
	    Student s2=new Student();
	    s2.setName("李四");
	    s2.setAge(20);
	    list.add(s1);
	    list.add(s2);
	    return list;
    }
}
