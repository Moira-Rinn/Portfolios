package com.sacha.portfolio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sacha.portfolio.models.Reply;

@Repository
public interface ReplyRepo extends CrudRepository<Reply, Long> {
	 List<Reply> findAll();
}
