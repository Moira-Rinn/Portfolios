package com.sacha.portfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.portfolio.models.Portfolio;
import com.sacha.portfolio.repositories.PortfolioRepo;

@Service
public class PortfolioService {
	
	@Autowired
	private PortfolioRepo portfolioRepository;
	
//GET ALL
	public List<Portfolio> all(){
		return portfolioRepository.findAll();
	}
//FIND BY ID
	public Optional<Portfolio> findById(Long id) {
		return portfolioRepository.findById(id);
	}
//ADD
	public Portfolio add(Portfolio portfolio) {
		return portfolioRepository.save(portfolio);
	}
//UPDATE
	public Portfolio update(Portfolio portfolio, Long id) {
		return portfolioRepository.save(portfolio);
	}
//DELETE
	public void delete(Long id) {
		portfolioRepository.deleteById(id);
	}
	//DELETE BOOK AND ASSOCIATED STARS
//		public void delete(List<Star> allStars, Long projectId) {
//			for(Star star : allStars) {
//				Project project = star.getStarred();
//				if(project.getId() == projectId) 
//					starsRepository.deleteById(star.getId());
//			}	
		}