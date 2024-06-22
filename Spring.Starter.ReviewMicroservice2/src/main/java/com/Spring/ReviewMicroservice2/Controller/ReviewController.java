package com.Spring.ReviewMicroservice2.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.ReviewMicroservice2.Entity.ReviewEntity;
import com.Spring.ReviewMicroservice2.Service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
		
	private ReviewService reviewServ;

	public ReviewController(ReviewService reviewServ) {
		super();
		this.reviewServ = reviewServ;
	}
	
	@PostMapping("/review")
	public ResponseEntity<String> createReview(@RequestParam long companyId , @RequestBody ReviewEntity review) {
			
		reviewServ.addReview(companyId, review);
		return ResponseEntity.ok("Review created!!");
	}
	
	@GetMapping("/review/{id}")
	public ResponseEntity<ReviewEntity> getReview(@RequestParam long companyId, @PathVariable long id) {
			
		ReviewEntity review = reviewServ.getReview(companyId, id);
		return ResponseEntity.ok(review);
	}
	
	@GetMapping("/allReview")
	public ResponseEntity<List<ReviewEntity>> getAllReview( long companyId) {
			
		List<ReviewEntity>	 review = reviewServ.getAllReviews(companyId);
		if(review!=null)
		return ResponseEntity.ok(review);
		else
			return new ResponseEntity<List<ReviewEntity>>(HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping("/review")
	public ResponseEntity<ReviewEntity> putReview(@RequestBody ReviewEntity review) {
			
		ReviewEntity updatedReview = reviewServ.updateReview(review.getReviewId(),review);
		return ResponseEntity.ok(updatedReview);
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<String> deleteReview(@RequestParam long companyId,  @PathVariable long id) {
			
		reviewServ.deleteReview(companyId, id);
		return ResponseEntity.ok("Review Deleted!!");
	}
	
	@GetMapping("/getAverage")
	public Double getAverageReview(@RequestParam long companyId) {
		return reviewServ.getAllReviews(companyId).stream().mapToDouble(c->c.getRating()).average().orElse(0.0);
	}
}





















