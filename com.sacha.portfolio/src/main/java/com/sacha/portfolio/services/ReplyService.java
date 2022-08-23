package com.sacha.portfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.portfolio.models.Reply;
import com.sacha.portfolio.repositories.ReplyRepo;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyRepo replyRepository;
	
//GET ALL
	public List<Reply> all(){
		return replyRepository.findAll();
	}
//GET ONE 
	public Optional<Reply> findById(Long id) {
		return replyRepository.findById(id);
	}
//ADD
	public Reply add(Reply reply) {
		return replyRepository.save(reply);
	}
//UPDATE
	public Reply update(Reply reply, Long id) {
		return replyRepository.save(reply);
	}
//DELETE
	public void delete(Long id) {
		replyRepository.deleteById(id);
	}
}