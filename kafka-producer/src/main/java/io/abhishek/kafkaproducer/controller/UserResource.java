package io.abhishek.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.abhishek.kafkaproducer.models.User;


@RestController
@RequestMapping("/kafka")
public class UserResource {
	
	@Autowired
	private KafkaTemplate<String,User> kafkaTemplate;
	
	private static final String TOPIC = "kafka-topic1";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") String name) {
		
		kafkaTemplate.send(TOPIC, new User(name,"CSE",9));
		
		return "published succesfully";
	}
	

}
