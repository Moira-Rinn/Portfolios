package com.sacha.portfolio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.portfolio.models.Rating;

@Repository
public interface ReplyRepo extends CrudRepository<Rating, Long> {
	 List<Rating> findAll();
}
