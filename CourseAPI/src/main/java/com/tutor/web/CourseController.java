package com.tutor.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping(method=RequestMethod.GET, value="/{name}")
	public String heartBeat(@PathVariable(name="name") String name) {
		return "Hi "+name+", how are you.";
	}
}
