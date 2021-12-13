package com.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.exam.service.UserService;

@SpringBootApplication
@CrossOrigin("*")
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Starting Code");
//		User user = new User();
//		user.setFirstname("Jitesh");
//		user.setLastname("Soni");
//		user.setEmail("jiteshsoni12.js@gmail.com");
//		user.setUsername("Jitesh12");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setPhone(9131147495L);
//		user.setProfile("Defalut.png");
//		user.setStatus(true);
//		
//		Role role = new Role();
//		role.setId(10L);
//		role.setRoleName("ADMIN");
//		
//		
//		Set<User_role> userRoleSet = new HashSet<>();
//		User_role userRole = new User_role();
//		
//		userRole.setRole(role);
//		
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
		
		
		
	}

}
