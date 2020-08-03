package com.spring.cloud.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/employees")
@RefreshScope
public class EmployeeController {
//	@Autowired
//	private CommonConfig commonConfig;
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${user.service.url.api.users}")
	String usersUrl;

	@Value("${user.service.url.api.welcome}")
	String userWelcomeUrl;
	
	@Value("${welcome.message}")
	String welcomeMessage;
	
	@GetMapping("/welcome") 
	public String welcome() {
		return welcomeMessage; // + "-->" + commonConfig.getAppName() + "--> " + commonConfig.getEnv();
	}
	
	@HystrixCommand(fallbackMethod = "fallbackWelcome")
	@GetMapping("/userWelcome") 
	public String callUsersWelcome() {
		System.out.println("user welcome");
		return restTemplate.getForObject(userWelcomeUrl, String.class);
	}
	public String fallbackWelcome() {
		return "from fallback method, sorry welcome api is not working at the moment.";
	}
	
	@GetMapping()
	public Result getAll(){
		return restTemplate.getForObject(usersUrl, Result.class);
	}
	
	@GetMapping("/{id}")
	public User getStudent(@PathVariable long id){
		return restTemplate.getForObject(usersUrl + "/" +id, User.class);
	}
}
