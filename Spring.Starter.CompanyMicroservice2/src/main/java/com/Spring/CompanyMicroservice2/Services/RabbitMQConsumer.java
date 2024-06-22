package com.Spring.CompanyMicroservice2.Services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.Spring.CompanyMicroservice2.Entity.ReviewMessage;

@Service
public class RabbitMQConsumer {
	
	private final CompanyService service;

	
	
	public RabbitMQConsumer(CompanyService service) {
		super();
		this.service = service;
	}



	@RabbitListener(queues = "companyRatingQueue")
	public void consumeMessage(ReviewMessage message) {
		service.updateCompanyRating(message);
		
	}

}
