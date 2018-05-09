package com.tutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tutor.model.Topic;

@Service
public class TopicService {
	private static List<Topic> topics = new ArrayList<>();
	static {
		topics.add(new Topic(1, "Java", "Java Course"));
		topics.add(new Topic(2, "Linux", "Linux Course"));
	}
	
	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopicByName(String name) {
		return topics.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic) {
		int i = 0;
		for(Topic tp : topics) {
			if(tp.getId().equals(topic.getId())) {
				topics.set(i, topic);
			}
			i++;
		}
	}

	public void deleteTopicByName(String name) {
		topics.removeIf(a -> a.getName().equalsIgnoreCase(name));
	}
}
