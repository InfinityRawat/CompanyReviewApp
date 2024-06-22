package com.Spring.CompanyMicroservice2.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Spring.CompanyMicroservice2.Entity.Company;
import com.Spring.CompanyMicroservice2.Entity.CompanyJobs;
import com.Spring.CompanyMicroservice2.Entity.JobEntity;
import com.Spring.CompanyMicroservice2.Entity.ReviewMessage;
import com.Spring.CompanyMicroservice2.Exception.CompanyAlreadyExistError;
import com.Spring.CompanyMicroservice2.Exception.CompanyNotExistException;
import com.Spring.CompanyMicroservice2.FeignClients.CompanyJobService;
import com.Spring.CompanyMicroservice2.FeignClients.ServiceFeignClient;
import com.Spring.CompanyMicroservice2.Repository.CompanyRepo;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepo repo;
	private ServiceFeignClient client;
	private CompanyJobService jobClient;

	

	public CompanyServiceImpl(CompanyRepo repo, ServiceFeignClient client, CompanyJobService jobclient) {
		this.repo = repo;
		this.client = client;
		this.jobClient=jobclient;
	}

	@Override
	public Company getCompany(long id) {
		
		return repo.findById(id).orElseThrow(()-> new CompanyNotExistException());
		
	}

	@Override
	public String createCompany(Company comp) {
		Optional<Company> company = repo.findById(comp.getId());
		if(company.isPresent()) {
			throw new CompanyAlreadyExistError();
		}
		repo.save(comp);
		return "Company Added";
	}

	@Override
	public Company upateCompany(Company comp) {
		Company company = getCompany(comp.getId());
		
		company.setName(comp.getName());
		company.setDescription(comp.getDescription());
		company.setName(comp.getName());
		
		repo.save(company);
		return company;
	}

	@Override
	public String deleteCompany(long id) {
		   getCompany(id);
			repo.deleteById(id);
		return "Company Deleted!! ";
	}

	@Override
	public List<Company> getAllCompany() {
		List<Company> comp = repo.findAll();
		return comp;
	}

	@Override
	public void updateCompanyRating(ReviewMessage message) {
		Company company = getCompany(message.getCompanyId());
		Double reviewAvg = client.getAverageReview(message.getCompanyId());
		company.setRating(reviewAvg);
		repo.save(company);
		
	}

	@Override
	public CompanyJobs getCompanyAllJobs(long companyId) {
		Company company = getCompany(companyId);
		List<JobEntity> jobs = jobClient.getCompanyAllJobs(companyId);
		CompanyJobs com = new CompanyJobs();
		com.setId(companyId);
		com.setDescription(company.getDescription());
		com.setName(company.getName());
		com.setRating(company.getRating());
		com.setJobs(jobs);
		
		return com;
	}

}
