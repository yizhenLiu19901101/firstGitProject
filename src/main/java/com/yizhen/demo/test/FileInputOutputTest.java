package com.yizhen.demo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import org.junit.Ignore;
import org.junit.Test;

public class FileInputOutputTest {

	/**
	 * 使用字符流读文件
	 * @throws IOException
	 */
	@Ignore
	public void testReaderRead() throws IOException {
		File file =  new File("d://file//demo1.txt");//文件路径
	    BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();
        while(temp!=null){
            sb.append(temp+" ");
            temp=br.readLine();
        }
	    System.out.println("文本的内容为：");
	    System.out.println("    " + sb.toString());
	   
    }
	
	/**
	 * 使用字符流写文件
	 * @throws IOException
	 */
	@Ignore
	public void testWriterWrite() throws IOException {
		  File file=new File("d://file//demo2.txt");
          if(!file.exists()) {
              file.createNewFile(); 
          }
	      BufferedWriter writer=new BufferedWriter(new FileWriter(file));        
          writer.write("Hello zhenzhen!");  
          writer.newLine();  
          writer.write("This is the writeTest.");  	        
	      writer.flush();  
	      writer.close();  
	        
    }
	
	/**
	 * 使用字节流写文件
	 * @throws IOException 
	 */
	@Ignore
	public void testStreamWrite() throws IOException {
		 File f = new File("d:" + File.separator+"file"+File.separator+"demo3.txt");
		 OutputStream out=new FileOutputStream(f);//如果文件不存在会自动创建
		 StringBuffer str= new StringBuffer("Hello World ");		 	 
		 str.append("\n\r");
		 str.append(" this is a write test");
		 byte[] b=str.toString().getBytes();
		 out.write(b);//因为是字节流，所以要转化成字节数组进行输出
		 out.close();
	}
	
	/**
	 * 使用字节流读文件
	 * @throws IOException 
	 */
	@Test
	public void testStreamRead() throws IOException {
		 File f = new File("d:" + File.separator+"file"+File.separator+"demo1.txt");
		 InputStream in=new FileInputStream(f);
		 byte[] b=new byte[1024];
		 int temp=0;
		 int len=0;
		 while((temp=in.read())!=-1){//-1为文件读完的标志
		     b[len]=(byte) temp;
		     len++;
		 }
		 in.close();
		 System.out.println(new String(b,0,len));
	}
}
