package com.tutor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutor.model.Topic;
import com.tutor.service.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Topic> getTopics() {
		return topicService.getTopics();
	}

	@RequestMapping(method=RequestMethod.GET, value="/{name}")
	public Topic getTopic(@PathVariable(name="name") String name) {
		return topicService.getTopicByName(name);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public List<Topic> addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topicService.getTopics();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{name}")
	public List<Topic> updateTopic(@RequestBody Topic topic, @PathVariable(name="name") String name) {
		topicService.updateTopic(topic);
		return topicService.getTopics();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{name}")
	public List<Topic> deleteTopic(@PathVariable(name="name") String name) {
		topicService.deleteTopicByName(name);
		return topicService.getTopics();
	}
}
