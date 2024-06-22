package com.Spring.CompanyMicroservice2.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="REVIEWMICROSERVICE",url="${reviewservice.url}")
public interface ServiceFeignClient {
	
	@GetMapping("reviews/getAverage")
	public Double getAverageReview(@RequestParam long companyId);
}
