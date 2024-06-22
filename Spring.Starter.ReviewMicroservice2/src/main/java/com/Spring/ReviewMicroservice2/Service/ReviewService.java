package com.Spring.ReviewMicroservice2.Service;

import java.util.List;

import com.Spring.ReviewMicroservice2.Entity.ReviewEntity;

public interface ReviewService {
	
	List<ReviewEntity> getAllReviews(long companyId);
    String addReview(long companyId, ReviewEntity review);
    ReviewEntity getReview(long companyId, long reviewId);
    ReviewEntity updateReview( long reviewId, ReviewEntity review);
    String deleteReview(long companyId, long reviewId);

}
