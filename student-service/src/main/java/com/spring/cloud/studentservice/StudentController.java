package com.spring.cloud.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private CommonConfig commonConfig;
	@Autowired
	@Lazy
	RestTemplate restTemplate;
	
	@Value("${user.service.url.api.users}")
	String usersUrl;
	
	@Value("${welcome.message}")
	String welcomeMessage;
	
	@GetMapping("/welcome") 
	public String welcome() {
		return welcomeMessage + "-->" + commonConfig.getAppName() + "--> " + commonConfig.getEnv();
	}
	
	@GetMapping()
	public Result getAll(){
		return restTemplate.getForObject(usersUrl, Result.class);//"http://localhost:8081/api/users/"
	}
	
	@GetMapping("/{id}")
	public User getStudent(@PathVariable long id){
		return restTemplate.getForObject(usersUrl + "/" +id, User.class);
	}
}
