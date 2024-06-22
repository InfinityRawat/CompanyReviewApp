package com.Spring.ReviewMicroservice2.RabbitMessageConfig;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
		
	
	@Bean
	 Queue publishQueue() {
		return new Queue("companyRatingQueue");
	}
	
	@Bean
	 MessageConverter msgConvert() {
		return new Jackson2JsonMessageConverter();
	}
	
	
	@Bean
	 RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
		
		RabbitTemplate template = new RabbitTemplate(factory);
		template.setMessageConverter(msgConvert());
		return template;
	}
}
