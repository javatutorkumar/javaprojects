package com.tutor.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.tutor.model.Topic;

@EnableJpaRepositories
public interface TopicRepository extends CrudRepository<Topic, Integer>{
	public Topic findByName(String name);
	
	@Transactional
	public void deleteByName(String name);
}
