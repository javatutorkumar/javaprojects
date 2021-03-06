package com.tutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.dao.TopicRepository;
import com.tutor.model.Topic;

@Service
public class TopicService {
	private static List<Topic> topics = new ArrayList<>();
	static {
		topics.add(new Topic(1, "Java", "Java Course"));
		topics.add(new Topic(2, "Linux", "Linux Course"));
		topics.add(new Topic(3, "SQL", "Sql Course"));
	}
	
	@Autowired
	TopicRepository repository;
	
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<>();
		repository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopicByName(String name) {
		return repository.findByName(name);
	}

	public void addTopic(Topic topic) {
		repository.save(topic);
	}

	public void updateTopic(Topic topic) { 
		repository.save(topic);
	}

	public void deleteTopicByName(String name) {
		repository.deleteByName(name);
	}
}
