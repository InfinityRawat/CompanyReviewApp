package com.Spring.CompanyMicroservice2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.CompanyMicroservice2.Entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {

}
