package org.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class KafkaProperties {

    private static final String BOOTSTRAP_SERVERS = "localhost:9094";
    private static final String GROUP_ID = "grupo1";


    public static Properties getConsumerProperties() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
        props.put("auto.commit.interval.ms", "1000");
        props.put("fetch.min.bytes", "1");
        props.put("fetch.max.wait.ms", "500");
        props.put("max.partition.fetch.bytes", "1048576");
        props.put("session.timeout.ms", "10000");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put("security.protocol","SASL_PLAINTEXT");
        props.put("sasl.enabled.mechanisms","GSSAPI");
        //props.put("sasl.mechanism.inter.broker.protocol","GSSAPI");
        props.put("sasl.kerberos.service.name","kafka");
        props.put("sasl.jaas.config","com.sun.security.auth.module.Krb5LoginModule required "
                +" debug=true"
                +" credsType=both"
                +" serviceName=\"kafka\""
                +" useKeyTab=true"
                +" storeKey=true"
                +" useTicketCache=false"
                +" keyTab=\"/home/b337289/Descargas/kafka/Desarrollo/kafka_user.keytab\""
                +" principal=\"kafka_user@CONTABILIDADBAZ.DEV.GS\";");
        return props;
    }


}
