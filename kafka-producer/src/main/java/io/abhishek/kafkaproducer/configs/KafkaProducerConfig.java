package io.abhishek.kafkaproducer.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import org.springframework.kafka.support.serializer.JsonSerializer;

import io.abhishek.kafkaproducer.models.User;

@Configuration
public class KafkaProducerConfig {
	
	private String bootstrapServer = "localhost:9092";
	//private static final String BOOTSTRAP_SERVERS_CONFIG = null;
	
	@Bean
	public ProducerFactory<String,User> producerFactory(){
		
		Map<String,Object> config = new HashMap<>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		
		return new DefaultKafkaProducerFactory<String, User>(config);
	}
	@Bean
	public KafkaTemplate<String,User> kafkaTemplate(){
		
		return new KafkaTemplate<String, User>(producerFactory());
	}

}
