package com.yizhen.demo.hadoop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class hdfsTest {

	Logger logger = LoggerFactory.getLogger(hdfsTest.class);
	
	@Ignore
	public void testHdfs() throws IOException {
		 String uri = "hdfs://127.0.0.1:9000/";
		 Configuration config = new Configuration();
		 FileSystem fs = FileSystem.get(URI.create(uri), config);
		 
		 logger.info("---开始---");
		 hdfsTest.showFile(logger, fs);
		 logger.info("---结束---");
	}
	
	@Ignore
	public void testIsExist() throws IOException {
		String uri = "hdfs://127.0.0.1:9000/";
		Configuration config = new Configuration();
		 //2.创建文件系统  
		FileSystem hdfs = FileSystem.get(URI.create(uri), config);
        //3.创建可供hadoop使用的文件系统路径
        Path file = new Path("/user/demo.txt");  
        // 4.判断文件是否存在(文件目标路径）
        if(hdfs.exists(file)) {
   		    InputStream is = hdfs.open(new Path("/user/demo.txt"));
   		    IOUtils.copyBytes(is, System.out, 1024, true);	 
        }else {
        	    logger.info("文件不存在!");
        }      
	}
	
	@Test
	public void testDirect() throws IOException {
		String uri = "hdfs://127.0.0.1:9000/";
		Configuration config = new Configuration();
		 //2.创建文件系统  
		FileSystem hdfs = FileSystem.get(URI.create(uri), config);
	    //创建目录
	    hdfs.mkdirs(new Path("/hbase"));
	}
	
	@Ignore
	public void testCreateFile() throws IOException {
		String uri = "hdfs://127.0.0.1:9000/";
		Configuration config = new Configuration();
		//2.创建文件系统  
		FileSystem hdfs = FileSystem.get(URI.create(uri), config);
		// 在hdfs的/user/fkong目录下创建一个文件，并写入一行文本
		FSDataOutputStream os = hdfs.create(new Path("/user/demo2.txt"));
		os.write("I`m okay!".getBytes());
		os.flush();
		os.close(); 
	}
	
	@Ignore
	public void testDelateFile() throws IOException {
		String uri = "hdfs://127.0.0.1:9000/";
		Configuration config = new Configuration();
		//2.创建文件系统  
		FileSystem hdfs = FileSystem.get(URI.create(uri), config);
		//3.删除文件和路径
		Boolean os = hdfs.delete(new Path("/user/demo.txt"),true);
		logger.info("结果："+os+"");
	}
	
	@Ignore
	public void testUploadFile() throws IOException {
		String uri = "hdfs://127.0.0.1:9000/";
		Configuration config = new Configuration();
		//2.创建文件系统  
		FileSystem hdfs = FileSystem.get(URI.create(uri), config);
		//3.删除文件和路径
		InputStream is = new FileInputStream("/users/liuyizhen/demo.txt");
		OutputStream os = hdfs.create(new Path("/user/demo.txt"));
		IOUtils.copyBytes(is, os, 1024, true);
	}
	
	
	public static void showFile(Logger logger,FileSystem fs) throws FileNotFoundException, IllegalArgumentException, IOException {
		 FileStatus[] statuses = fs.listStatus(new Path("/user"));
		 for (FileStatus status : statuses) {
		     logger.info(status.getPath()+"");
		 }
	}

}
