package com.sacha.resourceNetwork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.resourceNetwork.models.Possible;
import com.sacha.resourceNetwork.repositories.PossibleRepo;

@Service
public class PossibleService {
	
	@Autowired
	private PossibleRepo possibleRepository;
	
//GET ALL
	public List<Possible> findAll(){
		return possibleRepository.findAll();
	}
//FIND BY ID
	public Optional<Possible> findById(Long id) {
		return possibleRepository.findById(id);
	}
//ADD
	public Possible create(Possible possible) {
		return possibleRepository.save(possible);
	}
//UPDATE
	public Possible update(Possible possible, Long id) {
			return possibleRepository.save(possible);
	}
//DELETE
	public void delete(Long id) {
		possibleRepository.deleteById(id);
	}
}