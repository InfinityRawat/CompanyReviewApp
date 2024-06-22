package com.Spring.JobMicroservice2.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Spring.JobMicroservice2.DTOs.CompanyWithJobAndReviewDTO;
import com.Spring.JobMicroservice2.FeignClients.CompanyClient;
import com.Spring.JobMicroservice2.FeignClients.ReviewClient;
import com.Spring.JobMicroservice2.GlobalExceptions.JobAlreadyExistException;
import com.Spring.JobMicroservice2.GlobalExceptions.JobNotFoundException;
import com.Spring.JobMicroservice2.Mappers.JobToCompanyWithJobMapper;
import com.Spring.JobMicroservice2.Models.Company;
import com.Spring.JobMicroservice2.Models.JobEntity;
import com.Spring.JobMicroservice2.Models.ReviewEntity;
import com.Spring.JobMicroservice2.Repository.JobRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;


@Service
public class JobServiceImpl implements JobServices {
	
	
	
	private CompanyClient companyClient;
	private ReviewClient reviewClient;
	
	int count;


	public JobServiceImpl(JobRepository jobrepo,CompanyClient Cc, ReviewClient Rc) {
		super();
		this.jobrepo = jobrepo;
		this.companyClient=Cc;
		this.reviewClient=Rc;
	}

	private JobRepository jobrepo;

	@Override
	public CompanyWithJobAndReviewDTO getJob(long id) {
		Optional<JobEntity> jobOptional = jobrepo.findById(id);
		JobEntity job = jobOptional.orElseThrow(() -> new JobNotFoundException());
	 	
	 	System.out.println("http://COMPANYMICROSERVICE/companies/getCompany/"+job.getCompanyId()+"-------------------------Service URL");
	 	System.out.println("http://REVIEWMICROSERVICE/reviews/review/?companyId="+job.getCompanyId()+"-------------------------REview Service URL");

	 	
//		Company comp = 	restTemp.getForObject("http://COMPANYMICROSERVICE/companies/getCompany/"+job.getCompanyId(), Company.class);
	 	Company comp = companyClient.getCompany(job.getCompanyId());
		List<ReviewEntity> reviews = reviewClient.getAllReview(job.getCompanyId());
	
		return JobToCompanyWithJobMapper.mapper(job, comp,reviews);
	}

	@Override
	public JobEntity addJob(JobEntity job) {
		Optional<JobEntity> jb = jobrepo.findById(job.getId());
			if(jb.isPresent()) {
				throw new JobAlreadyExistException();
			}
			
		jobrepo.save(job);
		return job;
	}

	@Override
//	@CircuitBreaker(name="companyBreaker", fallbackMethod = "fallbackHandler")
	@Retry(name="companyBreaker", fallbackMethod = "fallbackHandler")
//	@RateLimiter(name="companyBreaker", fallbackMethod = "fallbackHandler")
	public List<CompanyWithJobAndReviewDTO> getAllJob() {
		
		System.out.println("No of times getAllJob is running::::::::::"+(++count));
		List<JobEntity> list = jobrepo.findAll();
		

		return list.stream().map(j->convertToDTO(j)).toList();
	}
	
	public List<String> fallbackHandler(Exception e){
		
		List<String> list =  new ArrayList<String>();
		list.add("Service not available.. Please try after sometime");
		list.add(e.getMessage());
		return list;
	}
	
//	public List<ReviewEntity> getAllReviews(long companyId){
//		
//		ResponseEntity<List<ReviewEntity>> resposeReview = restTemp.exchange(("http://REVIEWMICROSERVICE/reviews/allReview?companyId="+companyId),
//			HttpMethod.GET,
//			null,
//			new ParameterizedTypeReference<List<ReviewEntity>>() {}
//			);
//			List<ReviewEntity> reviews = resposeReview.getBody();
//			
//			return reviews;
//}
	
	private CompanyWithJobAndReviewDTO convertToDTO(JobEntity job) {
		
//		Company company = restTemp.getForObject("http://COMPANYMICROSERVICE/companies/getCompany/"+job.getCompanyId(), Company.class);
		Company company = companyClient.getCompany(job.getCompanyId());
		System.out.println("This is company we are looknig for :::::::::::::::::::::::::::::::::---:::::"+company);
		List<ReviewEntity> reviews = reviewClient.getAllReview(job.getCompanyId());
		
		
		return JobToCompanyWithJobMapper.mapper(job, company,reviews);
	}
	

	@Override
	public JobEntity updateJob(JobEntity job) {
		JobEntity entity = jobrepo.findById(job.getId()).orElseThrow(()-> new JobNotFoundException());
		entity.setCompanyId(job.getCompanyId());
		entity.setDescription(job.getDescription());
		entity.setLocation(job.getLocation());
		entity.setMaxSalary(job.getMaxSalary());
		entity.setMinSalary(job.getMinSalary());
		entity.setTitle(job.getTitle());
		
		jobrepo.save(entity);
		
		return entity;
	}

	@Override
	public String deleteJob(long id) {
		 getJob(id);
		jobrepo.deleteById(id);
		return "Entry Deleted";
	}

	@Override
	public List<JobEntity> getAllJobByCompanyId(long id) {
		
		List<JobEntity> jobs = jobrepo.findAllByCompanyId(id);
		return jobs;
	}

}
