package com.Spring.ReviewMicroservice2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Spring.ReviewMicroservice2.Entity.ReviewEntity;
import com.Spring.ReviewMicroservice2.Repository.ReviewRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository repo;
	
	private RabbitMessageProducer producer;

	public ReviewServiceImpl(ReviewRepository repo, RabbitMessageProducer producer) {
		super();
		this.repo = repo;
		this.producer=producer;
	}

	@Override
	public List<ReviewEntity> getAllReviews(long companyId) {
		List<ReviewEntity> review = repo.findAllByCompanyId(companyId);

		return review;
	}

	@Override
	public String addReview(long companyId, ReviewEntity review) {

		if (companyId != 0) {
			review.setCompanyId(companyId);
			repo.save(review);
			producer.sendMessage(review);

			return "Review Added";

		}
		return "Review's Company Not found";
	}

	@Override
	public ReviewEntity getReview(long companyId, long reviewId) {

		Optional<ReviewEntity> review = repo.findByCompanyIdAndReviewId(companyId, reviewId);

		return review.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public ReviewEntity updateReview( long reviewId, ReviewEntity review) {

		ReviewEntity updatedReview = repo.findById(reviewId).orElse(null);

		if (updatedReview != null) {
			updatedReview.setDescription(review.getDescription());
			updatedReview.setRating(review.getRating());
			updatedReview.setTitle(review.getTitle());
			updatedReview.setCompanyId(review.getCompanyId());
			repo.save(updatedReview);
		}
		return getReview(review.getCompanyId(), reviewId);

	}

	@Override
	public String deleteReview(long companyId, long reviewId) {
		getReview(companyId, reviewId);
		repo.deleteByCompanyIdAndReviewId(companyId, reviewId);
		return "item deleted!!";
	}

}
