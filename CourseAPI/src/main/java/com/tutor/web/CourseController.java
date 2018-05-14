package com.tutor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutor.model.Topic;

@Controller
public class CourseController {
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String heartBeat(Model model) {
		model.addAttribute("topic", new Topic());
		return "topics";
	}
}
