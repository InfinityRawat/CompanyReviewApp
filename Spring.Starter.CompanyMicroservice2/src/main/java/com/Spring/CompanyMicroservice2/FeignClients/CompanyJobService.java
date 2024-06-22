package com.Spring.CompanyMicroservice2.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Spring.CompanyMicroservice2.Entity.JobEntity;

@FeignClient(name="JobMicroservice", url="${jobservice.url}")
public interface CompanyJobService {
		
	@GetMapping("v1/jobs/getCompanyAllJobs/{id}")
	public List<JobEntity> getCompanyAllJobs(@PathVariable long id);
}
