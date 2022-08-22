package com.sacha.portfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.portfolio.models.Rating;
import com.sacha.portfolio.repositories.RatingRepo;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepo ratingRepository;
	
//GET ALL
	public List<Rating> all(){
		return ratingRepository.findAll();
	}
//GET ONE 
	public Optional<Rating> findById(Long id) {
		return ratingRepository.findById(id);
	}
//ADD
	public Rating add(Rating rating) {
		return ratingRepository.save(rating);
	}
//UPDATE
	public Rating update(Rating rating, Long id) {
		return ratingRepository.save(rating);
	}
//DELETE
	public void delete(Long id) {
		ratingRepository.deleteById(id);
	}
}