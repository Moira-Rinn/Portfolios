package com.sacha.portfolio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.portfolio.models.Portfolio;

@Repository
public interface PortfolioRepo extends CrudRepository<Portfolio, Long> {
	List<Portfolio> findAll();
}

