package com.yizhen.demo.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringEncoder;
 
public class TestConsumer {
    static final String topic = "test";
    public static void main(String[] args) {
	     Properties prop = new Properties();
	     prop.put("zookeeper.connect", "localhost:2181");
		 prop.put("serializer.class", StringEncoder.class.getName());
		 prop.put("metadata.broker.list", "localhost:9092");
		 prop.put("group.id", "group1");
		 ConsumerConnector consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(prop));
		 Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		 topicCountMap.put(topic, 1);
		 Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = consumer.createMessageStreams(topicCountMap);
		 final KafkaStream<byte[], byte[]> kafkaStream = messageStreams.get(topic).get(0);
		 ConsumerIterator<byte[], byte[]> iterator = kafkaStream.iterator();
		 while (iterator.hasNext()) {
		     String msg = new String(iterator.next().message());
		     System.out.println("收到消息："+msg);
		 }
     }
}
