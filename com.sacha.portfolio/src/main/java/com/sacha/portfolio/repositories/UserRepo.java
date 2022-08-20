package com.sacha.portfolio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.portfolio.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	 User findByEmail(String email);
}
