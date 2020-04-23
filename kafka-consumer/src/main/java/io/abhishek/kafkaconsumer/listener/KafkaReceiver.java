package io.abhishek.kafkaconsumer.listener;

import io.abhishek.kafkaconsumer.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {
	
	
   private Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);
	@KafkaListener(topics = "kafka-topic1", groupId = "kafka-group1",containerFactory = "kafkaListenerConatinerFactory")
	public void consume(User user) {
		logger.info("consumed message: "
				+user);
	}

}
