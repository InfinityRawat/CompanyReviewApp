package com.Spring.CompanyMicroservice2.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyJobs {
	 private Long id;
	    private String name;
	    private String description;
	    private Double rating;
	    List<JobEntity> jobs;
}
