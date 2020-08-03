package com.spring.cloud.studentservice;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/courses")
public class CourseController {
	@GetMapping()
	public String getAll(){
		return "course1, course2";
	}
}
