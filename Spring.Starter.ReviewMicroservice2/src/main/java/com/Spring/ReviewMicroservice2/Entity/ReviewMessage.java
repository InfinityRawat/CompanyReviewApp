package com.Spring.ReviewMicroservice2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewMessage {

	private long reviewId;
	private String title;
	private String description;
	private double rating;
	private long companyId;
}
