package com.Spring.JobMicroservice2.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.JobMicroservice2.DTOs.CompanyWithJobAndReviewDTO;
import com.Spring.JobMicroservice2.Models.JobEntity;
import com.Spring.JobMicroservice2.Services.JobServices;

@Controller
@RequestMapping("/v1/jobs")
public class JobController {
		
	private JobServices service;

	public JobController(JobServices service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/job")
	public ResponseEntity<String> createJobEntry(@RequestBody JobEntity job){
		
		
		service.addJob(job);
		
		return new ResponseEntity<String>("JobCreated",HttpStatus.OK);
	}
	
	@GetMapping("/job/{id}")
	public ResponseEntity<CompanyWithJobAndReviewDTO> getById(@PathVariable long id){
		
		CompanyWithJobAndReviewDTO job = service.getJob(id);
		
		return new ResponseEntity<CompanyWithJobAndReviewDTO>(job,HttpStatus.CREATED);
	}
	
	@GetMapping("/allJobs")
	public ResponseEntity<List<CompanyWithJobAndReviewDTO>> getAll(){
		
		List<CompanyWithJobAndReviewDTO> jobs = service.getAllJob();
		
		return new ResponseEntity<List<CompanyWithJobAndReviewDTO>>(jobs,HttpStatus.FOUND);
	}
	
	@PutMapping("/jobUpdate")
	public ResponseEntity<JobEntity> updateJob(@RequestBody JobEntity job){
		
			JobEntity entity = service.updateJob(job);
			
			return new ResponseEntity<JobEntity>(entity,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable long id){
			service.deleteJob(id);
			return new ResponseEntity<String>("Job Deleted",HttpStatus.OK);
	}
	
	
	@GetMapping("/getCompanyAllJobs/{id}")
	public ResponseEntity<List<JobEntity>> getCompanyAllJobs(@PathVariable long id)
	{
		List<JobEntity> result = service.getAllJobByCompanyId(id);
			return ResponseEntity.ok(result);
	}
	
}
