package com.yizhen.demo.hadoop;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan; 

public class hbaseTest {

	Logger logger = LoggerFactory.getLogger(hbaseTest.class);
	public static Configuration configuration; 
	
	
	@Ignore
	public void scanTables() throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
        configuration = HBaseConfiguration.create(); 
	    configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
	    configuration.set("hbase.zookeeper.quorum", "127.0.0.1"); 
	    configuration.set("hbase.master", "127.0.0.1:600000"); 
		HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration); 
	    logger.info("*********************************************");
        String[] tableNames = hBaseAdmin.getTableNames();
        for(String tableName:tableNames) {
            System.out.println("table = "+tableName);
        }
        logger.info("*********************************************");
	}
	
	
	@Ignore
	public void createTable() throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
        configuration = HBaseConfiguration.create(); 
	    configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
	    configuration.set("hbase.zookeeper.quorum", "127.0.0.1"); 
	    configuration.set("hbase.master", "127.0.0.1:600000"); 
		HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration); 
	    logger.info("*********************************************");
        if (hBaseAdmin.tableExists("tb_employee")) {// 如果存在要创建的表，那么先删除，再创建 
            logger.info("表存在");
        }else {     
        	  logger.info("表不存在");
        }
	    @SuppressWarnings("deprecation")
		HTableDescriptor tableDescriptor = new HTableDescriptor("tb_employee"); 
        tableDescriptor.addFamily(new HColumnDescriptor("name")); 
        tableDescriptor.addFamily(new HColumnDescriptor("department")); 
        tableDescriptor.addFamily(new HColumnDescriptor("age")); 
        hBaseAdmin.createTable(tableDescriptor); 
        logger.info("*********************************************");
        if (hBaseAdmin.tableExists("tb_employee")) {// 如果存在要创建的表，那么先删除，再创建 
            logger.info("表存在");
        }else {     
        	  logger.info("表不存在");
        }
	}
	
	@Ignore
	public void deleteTable() throws IOException {
        configuration = HBaseConfiguration.create(); 
	    configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
	    configuration.set("hbase.zookeeper.quorum", "127.0.0.1");
	    configuration.set("hbase.master", "127.0.0.1:600000"); 
	    @SuppressWarnings({ "deprecation", "resource" })
		HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration); 
	    logger.info("*********************************************");
        if (hBaseAdmin.tableExists("tb_employee")) {// 如果存在要创建的表，那么先删除，再创建 
            logger.info("表存在");
            hBaseAdmin.disableTable("tb_employee");
            hBaseAdmin.deleteTable("tb_employee");
            logger.info(hBaseAdmin.tableExists("tb_employee") + "");
        }else {     
        	  logger.info("表不存在");
        }
	   
	}
	
	@Ignore
	public void insertData() throws IOException {
	    configuration = HBaseConfiguration.create(); 
	    configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
	    configuration.set("hbase.zookeeper.quorum", "127.0.0.1"); 
	    configuration.set("hbase.master", "127.0.0.1:600000"); 
        HTable table = new HTable(configuration,"scores");
        logger.info("开始插入数据");
        try { 
        	   Put put = new Put("xuexue".getBytes());
        	   put.add("course".getBytes(),"music".getBytes(),"100".getBytes());
           table.put(put);
        } catch (IOException e) { 
           e.printStackTrace(); 
        }
        logger.info("完成插入数据");
	}
	
	
	@Ignore 
	public void deleteDate() throws IOException{
        configuration = HBaseConfiguration.create(); 
	    configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
	    configuration.set("hbase.zookeeper.quorum", "127.0.0.1"); 
	    configuration.set("hbase.master", "127.0.0.1:600000"); 
        HTable table = new HTable(configuration,"scores");
        logger.info("开始删除数据");
        try { 
        	   Delete delete = new Delete("zhenzhen".getBytes());
        	   delete.addColumn("grad".getBytes(), null);
        	   table.delete(delete);
        } catch (IOException e) { 
           e.printStackTrace(); 
        }
        logger.info("完成删除数据");
	}
	
	
	@Ignore
	 public void QueryAll() throws IOException { 
         configuration = HBaseConfiguration.create(); 
	     configuration.set("hbase.zookeeper.property.clientPort", "2181"); 
	     configuration.set("hbase.zookeeper.quorum", "127.0.0.1"); 
	     configuration.set("hbase.master", "127.0.0.1:600000"); 
         HTable table = new HTable(configuration,"scores");
         try { 
             ResultScanner rs = table.getScanner(new Scan()); 
             for (Result r : rs) { 
                 System.out.println("获得到rowkey:" + new String(r.getRow())); 
                 for (KeyValue keyValue : r.raw()) { 
                     System.out.println("列族：" + new String(keyValue.getFamily()) +" 列: "+new String(keyValue.getQualifier())
                            + "====值:" + new String(keyValue.getValue())); 
                 } 
             } 
         } catch (IOException e) { 
             e.printStackTrace(); 
         } 
	} 
}




