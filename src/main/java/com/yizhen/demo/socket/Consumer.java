package com.yizhen.demo.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Consumer {
	
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException {
	
		String interfacename = SayHellloService.class.getName();
	    Method method =  SayHellloService.class.getMethod("sayHello", java.lang.String.class);
	    Object [] arguments = {"hello"};
	    Socket socket = new Socket("127.0.0.1",1234);
	    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
	    output.writeUTF(interfacename);
	    output.writeUTF(method.getName());
	    output.writeObject(arguments);
	    
	    ObjectInputStream input =new ObjectInputStream(socket.getInputStream());
	    Object result = input.readObject();
	    System.out.println(result.toString());
	}
	

        
	

}
