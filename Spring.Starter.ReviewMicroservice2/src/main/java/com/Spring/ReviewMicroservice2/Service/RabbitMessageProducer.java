package com.Spring.ReviewMicroservice2.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.Spring.ReviewMicroservice2.Entity.ReviewEntity;
import com.Spring.ReviewMicroservice2.Entity.ReviewMessage;

@Service
public class RabbitMessageProducer {
	
	private final RabbitTemplate template;

	public RabbitMessageProducer(RabbitTemplate template) {
		this.template = template;
	}
	
	public void sendMessage(ReviewEntity review) {
		
		ReviewMessage message = new ReviewMessage();
		message.setReviewId(review.getReviewId());
		message.setDescription(review.getDescription());
		message.setRating(review.getRating());
		message.setTitle(review.getTitle());
		message.setCompanyId(review.getCompanyId());
		
		template.convertAndSend("companyRatingQueue",message);
	}

}
