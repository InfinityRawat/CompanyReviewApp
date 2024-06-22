package com.Spring.CompanyMicroservice2.Services;

import java.util.List;

import com.Spring.CompanyMicroservice2.Entity.Company;
import com.Spring.CompanyMicroservice2.Entity.CompanyJobs;
import com.Spring.CompanyMicroservice2.Entity.ReviewMessage;

public interface CompanyService {
	public Company getCompany(long id);
	
	public String createCompany(Company comp);
	public Company upateCompany(Company comp);
	public String deleteCompany(long id);
	
	public List<Company> getAllCompany();
	
	public void updateCompanyRating(ReviewMessage message);
	public CompanyJobs getCompanyAllJobs(long companyId);

}
