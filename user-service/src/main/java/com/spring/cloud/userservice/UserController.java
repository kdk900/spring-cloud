package com.spring.cloud.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/api/users")
@RequestScope
public class UserController {

	@Value("${welcome.message}")
	String welcomeMessage;
	
	@GetMapping("/welcome") 
	public String welcome()  {
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return welcomeMessage;
	}
	
	@GetMapping()
	public Result getAll() {
		Result result = new Result();
		List<User> users = new ArrayList<>();
		users.add(new User(1, "kalyan", "kadale"));
		users.add(new User(2, "nilesh", "pawar"));
		result.setUsers(users);
		return result;
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {
		return new User(id, "kalyan", "kadale");
	}
}
