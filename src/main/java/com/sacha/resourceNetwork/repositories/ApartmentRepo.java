package com.sacha.resourceNetwork.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.resourceNetwork.models.Apartment;

@Repository
public interface ApartmentRepo extends CrudRepository<Apartment, Long> {
	 List<Apartment> findAll();
}
