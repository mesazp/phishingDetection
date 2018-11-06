package sockettest;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Consumer {
	public static void main(String[] args) {
    	
        Socket client = null;
    	String topic="myTopic";
        Properties props = new Properties();  
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "hello-group");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000"); 
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            
        KafkaConsumer consumer = new KafkaConsumer(props);  
        consumer.subscribe(Collections.singletonList(topic), new ConsumerRebalanceListener() {  
            @Override  
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {  
  
            }  
            @Override  
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {  
  
            }  
        });  
        while (true) {  
            ConsumerRecords<String, String> records = consumer.poll(100);  
            for (ConsumerRecord<String, String> record : records) {  
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());  
                String url=record.value();
                try{
        		client = new Socket("127.0.0.1",8888);
        		String msg=url;
        		//得到socket读写流,向服务端程序发送数据 
        		client.getOutputStream().write(msg.getBytes());
        		byte[] datas = new byte[2048];
        		//从服务端程序接收数据
        		client.getInputStream().read(datas);
        		System.out.println(new String(datas));
                }catch(Exception e){
            		e.printStackTrace();
            	}finally 
                {
            		if (client != null) {
            	try 
            	{
            		client.close();
            	} catch (IOException e)
            	{
            		System.out.println("systemerr:" +e);
            	}
            	}
            }
            try {  
                TimeUnit.MICROSECONDS.sleep(100);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } 
           }
        }  
    }  
}
