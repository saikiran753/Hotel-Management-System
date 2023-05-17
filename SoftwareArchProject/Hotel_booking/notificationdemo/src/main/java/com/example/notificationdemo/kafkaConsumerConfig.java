package com.example.notificationdemo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class kafkaConsumerConfig {

    @Value("${kafka.broker.address}")
    private String kafkaBrokerAddress;
    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String, Object> configProps = new HashMap<String,Object>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerAddress);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG,"consumer-notification-group");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        return new DefaultKafkaConsumerFactory<>(configProps);
    }
}
