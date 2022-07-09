package com.sacha.resourceNetwork.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.resourceNetwork.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	 User findByEmail(String email);
}
