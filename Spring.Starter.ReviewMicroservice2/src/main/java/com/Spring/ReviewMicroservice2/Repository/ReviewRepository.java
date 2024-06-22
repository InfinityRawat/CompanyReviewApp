package com.Spring.ReviewMicroservice2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.ReviewMicroservice2.Entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

	List<ReviewEntity> findAllByCompanyId(long companyId);

	Optional<ReviewEntity> findByCompanyIdAndReviewId(long companyId,long reviewId );

	void deleteByCompanyIdAndReviewId(Long companyId, Long reviewId);

}
