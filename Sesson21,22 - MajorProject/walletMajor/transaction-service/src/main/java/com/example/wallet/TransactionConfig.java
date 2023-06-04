package com.example.wallet;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class TransactionConfig{
	
	@Bean
	ObjectMapper getMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
	Properties getProducerProperties() {
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return properties;
		
	}
	
	Properties getConsumerProperties() {
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return properties;
		
	}
	
	ProducerFactory getProducerFactory() {
		return new DefaultKafkaProducerFactory(getProducerProperties());
	}
	
	@Bean
	ProducerFactory getConsumerFactory() {
		return new DefaultKafkaProducerFactory(getConsumerProperties());
	}
	
	@Bean
	KafkaTemplate<String, String> getKafkaTemplate(){
		return new KafkaTemplate(getProducerFactory());
	}


}
