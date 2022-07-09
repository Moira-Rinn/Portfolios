package com.sacha.resourceNetwork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.resourceNetwork.models.Contact;
import com.sacha.resourceNetwork.repositories.ContactRepo;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepo contactRepository;
	
//GET ALL
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
//FIND BY ID
	public Optional<Contact> findById(Long id) {
		return contactRepository.findById(id);
	}
//ADD
	public Contact create(Contact contactUser) {
		return contactRepository.save(contactUser);
	}
//UPDATE
		public Contact update(Contact contactUser, Long id) {
			return contactRepository.save(contactUser);
		}
//DELETE
	public void delete(Long id) {
		contactRepository.deleteById(id);
	}
}