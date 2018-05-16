package com.yizhen.demo.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class RMIService {
    public static void main(String[] args) {
        try {
            StudentService studentService=new StudentServiceImpl();
            //在特定主机上启动远程对象注册
            LocateRegistry.createRegistry(5008);//定义端口号           
            Naming.rebind("rmi://127.0.0.1:5008/StudentService", studentService);            
            System.out.println("服务已启动");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}