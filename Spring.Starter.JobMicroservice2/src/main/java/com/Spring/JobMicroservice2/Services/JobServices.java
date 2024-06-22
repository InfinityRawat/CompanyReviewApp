package com.Spring.JobMicroservice2.Services;

import java.util.List;

import com.Spring.JobMicroservice2.DTOs.CompanyWithJobAndReviewDTO;
import com.Spring.JobMicroservice2.Models.JobEntity;


public interface JobServices {
	
	public CompanyWithJobAndReviewDTO getJob(long id);
	public JobEntity addJob(JobEntity job);
	public List<CompanyWithJobAndReviewDTO> getAllJob();
	public JobEntity updateJob(JobEntity job);
	public String deleteJob(long id);
	public List<JobEntity> getAllJobByCompanyId(long id);
	
	

}
