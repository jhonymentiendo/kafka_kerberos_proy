package org.example;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
       props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.97.26.52:9092");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("buffer.memory", 33554432);

        KafkaProducer<String, String> prod = new KafkaProducer<>(props);
        String topic ="aws.dev.public.batch.0";
        int partition =0;
        String key="llave";
        String value="Desde Maven";
        prod.send(new ProducerRecord<>(topic,partition,key,value));
        prod.close();

    }


}
