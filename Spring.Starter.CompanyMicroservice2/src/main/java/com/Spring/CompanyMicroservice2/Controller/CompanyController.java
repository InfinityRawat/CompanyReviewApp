package com.Spring.CompanyMicroservice2.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CompanyMicroservice2.Entity.Company;
import com.Spring.CompanyMicroservice2.Entity.CompanyJobs;
import com.Spring.CompanyMicroservice2.Services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService serv;

	public CompanyController(CompanyService serv) {
		super();
		this.serv = serv;
	}
	
	@PostMapping("/saveCompany")
	public ResponseEntity<String> createCompany(@RequestBody Company company)
	{
			String result = serv.createCompany(company);
			return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getCompany/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable int id)
	{
			Company result = serv.getCompany(id);
			return ResponseEntity.ok(result);
	}
	
	@GetMapping("/allCompanies")
	public ResponseEntity<List<Company>> getAllCompany(){
			
		List<Company> companies = serv.getAllCompany();
			return ResponseEntity.ok(companies);
	}
	
	@PutMapping("/company")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company){
		
		Company companies = serv.upateCompany(company);
			return ResponseEntity.ok(companies);
	}
	

	@GetMapping("/getCompanyAllJobs/{id}")
	public ResponseEntity<CompanyJobs> getCompanyAllJobs(@PathVariable int id)
	{
		CompanyJobs result = serv.getCompanyAllJobs(id);
			return ResponseEntity.ok(result);
	}
}
