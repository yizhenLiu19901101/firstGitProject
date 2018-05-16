package com.yizhen.demo.rmi;

import java.rmi.Naming;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
        	    //关键代码，从远程对象注册地获得远程对象
            StudentService studentService=(StudentService) Naming.lookup("rmi://127.0.0.1:5008/StudentService");
            List<Student> list = studentService.getList();
            for (Student s : list) {
                System.out.println("姓名："+s.getName()+",年龄："+s.getAge());
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
   }
 }
