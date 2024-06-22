package com.Spring.JobMicroservice2.Mappers;

import java.util.List;

import com.Spring.JobMicroservice2.DTOs.CompanyWithJobAndReviewDTO;
import com.Spring.JobMicroservice2.Models.Company;
import com.Spring.JobMicroservice2.Models.JobEntity;
import com.Spring.JobMicroservice2.Models.ReviewEntity;

public class JobToCompanyWithJobMapper {
	
	public static CompanyWithJobAndReviewDTO  mapper(JobEntity job,Company company,List<ReviewEntity> review) {
			
		CompanyWithJobAndReviewDTO cj = new CompanyWithJobAndReviewDTO();
		
		cj.setId(job.getId());
		cj.setDescription(job.getDescription());
		cj.setLocation(job.getLocation());
		cj.setMaxSalary(job.getMaxSalary());
		cj.setMinSalary(job.getMinSalary());
		cj.setTitle(job.getTitle());
		cj.setCompany(company);
		cj.setReviews(review);
		return cj;
	}

}
