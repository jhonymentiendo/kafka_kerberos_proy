
package org.example;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;


public class consumer {
    private static final String TOPICO = "aws.dev.public.batch.0";
    private KafkaConsumer<String, byte[]> consumer;

    public consumer() {
        this(0);
    }

    public consumer(int particion) {
        System.setProperty("java.security.krb5.conf", "/home/b337289/Descargas/kafka/Desarrollo/krb5.conf");
        this.consumer = new KafkaConsumer<>(KafkaProperties.getConsumerProperties());

        try{
            this.consumer.subscribe(Collections.singletonList(TOPICO));
            while (true) {
                ConsumerRecords<String, byte[]> records = this.consumer.poll(Duration.ofSeconds(15));
                for (ConsumerRecord<String, byte[]> record : records){
                    DatumReader<topLevelRecord> datumReader = new SpecificDatumReader<>(topLevelRecord.getClassSchema());
                    Decoder decoder = DecoderFactory.get().binaryDecoder(record.value(), null);
                    GenericRecord result = datumReader.read(null, decoder);
                    System.out.println("\u001B[3"+particion+"m particion:"   + record.partition() +" - "+ result.toString() + "\033[0m");



                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.consumer.close();
        }
    }
}