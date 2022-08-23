package com.sacha.portfolio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.portfolio.models.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
	 List<Comment> findAll();
}
