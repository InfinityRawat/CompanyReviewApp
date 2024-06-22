package com.Spring.JobMicroservice2.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Spring.JobMicroservice2.Models.Company;

@FeignClient(name = "COMPANYMICROSERVICE",url="${companyservice.url}")
public interface CompanyClient {

	@GetMapping("companies/getCompany/{id}")
	public Company getCompany(@PathVariable long id);
	
}
