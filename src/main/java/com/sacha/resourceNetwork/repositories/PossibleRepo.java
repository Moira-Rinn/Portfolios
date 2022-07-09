package com.sacha.resourceNetwork.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.resourceNetwork.models.Possible;

@Repository
public interface PossibleRepo extends CrudRepository<Possible, Long> {
	List<Possible> findAll();
}
