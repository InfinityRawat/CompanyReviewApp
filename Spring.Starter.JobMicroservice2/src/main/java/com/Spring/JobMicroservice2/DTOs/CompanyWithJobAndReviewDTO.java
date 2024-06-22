package com.Spring.JobMicroservice2.DTOs;

import java.util.List;

import com.Spring.JobMicroservice2.Models.Company;
import com.Spring.JobMicroservice2.Models.ReviewEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyWithJobAndReviewDTO {
	private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
	private Company company;
	private List<ReviewEntity> reviews;
}
