package com.Spring.JobMicroservice2.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring.JobMicroservice2.Models.ReviewEntity;

@FeignClient(name="REVIEWMICROSERVICE",url="${reviewservice.url}")
public interface ReviewClient {

	@GetMapping("reviews/allReview")
	public List<ReviewEntity> getAllReview( @RequestParam long companyId);
}
