package com.sacha.resourceNetwork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.resourceNetwork.models.Apartment;
import com.sacha.resourceNetwork.models.Possible;
import com.sacha.resourceNetwork.repositories.ApartmentRepo;
import com.sacha.resourceNetwork.repositories.PossibleRepo;

@Service
public class ApartmentService {

	@Autowired
	private ApartmentRepo apartmentRepository;
	@Autowired
	private PossibleRepo possibleRepository;
	
//GET ALL
	public List<Apartment> all(){
		return apartmentRepository.findAll();
	}
//GET ONE 
	public Optional<Apartment> findOne(Long id) {
		return apartmentRepository.findById(id);
	}
//ADD
	public Apartment add(Apartment apartment) {
		return apartmentRepository.save(apartment);
	}
//UPDATE
	public Apartment update(Apartment apartment, Long id) {
		return apartmentRepository.save(apartment);
	}
//DELETE
	public void delete(Long id) {
		apartmentRepository.deleteById(id);
	}
//DELETE BOOK AND ASSOCIATED STARS
	public void delete(List<Possible> allStars, Long bookId) {
		for(Possible possible : allStars) {
			Apartment apartment = possible.getApartment();
			if(apartment.getId() == bookId) 
				possibleRepository.deleteById(possible.getId());
		}	
	}
}