package com.tutor.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutor.model.Topic;
import com.tutor.service.TopicService;

@Controller
@RequestMapping("/topics1")
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getTopics(Model model) {
		model.addAttribute("topics", topicService.getTopics());
		return "topicResults";
	}

	@RequestMapping(method=RequestMethod.GET, value="/{name}")
	public String getTopic(@PathVariable(name="name") String name, Model model) {
		Topic topic = topicService.getTopicByName(name);
		List<Topic> topics = new ArrayList<>();
		topics.add(topic);
		model.addAttribute("topics", topics);
		return "topicResults";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addTopic(@ModelAttribute Topic topic, Model model) {
		topicService.addTopic(topic);
		return getTopics(model);
	}
}
