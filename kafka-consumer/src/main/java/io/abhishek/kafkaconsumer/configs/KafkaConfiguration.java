package io.abhishek.kafkaconsumer.configs;

import java.util.HashMap;
import java.util.Map;

import io.abhishek.kafkaconsumer.models.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class KafkaConfiguration {
	
	private String bootstrapServer = "localhost:9092";
	@Bean
	public ConsumerFactory<String, User> consumerFactory(){

		JsonDeserializer<User> deserializer = new JsonDeserializer<>(User.class);
		deserializer.setRemoveTypeHeaders(false);
		deserializer.addTrustedPackages("*");
		deserializer.setUseTypeMapperForKey(true);
		
		Map<String,Object> config = new HashMap();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,deserializer );
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		
		
		return new DefaultKafkaConsumerFactory(config,new StringDeserializer(),deserializer);
		
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,User> kafkaListenerConatinerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,User> factory = new ConcurrentKafkaListenerContainerFactory() ;
		factory.setConsumerFactory(consumerFactory());
		
		return factory;
		
		
	}

}
