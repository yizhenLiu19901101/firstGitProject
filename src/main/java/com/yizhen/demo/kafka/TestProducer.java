package com.yizhen.demo.kafka;

import java.util.Properties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;
 
public class TestProducer {
    public static void main(String[] args) throws Exception {
	    Properties prop = new Properties();
	    //2181是zookeeper的端口号
	    prop.put("zookeeper.connect", "localhost:2181");
		//9092是kafka的生产者的端口号
	    prop.put("metadata.broker.list", "localhost:9092");
		prop.put("serializer.class", StringEncoder.class.getName());
		Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(prop));
		int i = 0;
		while(true){
		    producer.send(new KeyedMessage<String, String>("test", "msg:第"+i+++"天"));
		    Thread.sleep(1000);
	    }
    }
}