package com.Spring.JobMicroservice2.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {

	private long reviewId;
	private String title;
	private String description;
	private double rating;
}
