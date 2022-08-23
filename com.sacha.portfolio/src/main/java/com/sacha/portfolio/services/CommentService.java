package com.sacha.portfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.portfolio.models.Comment;
import com.sacha.portfolio.repositories.CommentRepo;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepo commentRepository;
	
//GET ALL
	public List<Comment> all(){
		return commentRepository.findAll();
	}
//GET ONE 
	public Optional<Comment> findById(Long id) {
		return commentRepository.findById(id);
	}
//ADD
	public Comment add(Comment comment) {
		return commentRepository.save(comment);
	}
//UPDATE
	public Comment update(Comment comment, Long id) {
		return commentRepository.save(comment);
	}
//DELETE
	public void delete(Long id) {
		commentRepository.deleteById(id);
	}
}