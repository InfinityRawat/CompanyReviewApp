package com.Spring.JobMicroservice2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.JobMicroservice2.Models.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity,Long>{

	List<JobEntity> findAllByCompanyId(long id);

	
}
