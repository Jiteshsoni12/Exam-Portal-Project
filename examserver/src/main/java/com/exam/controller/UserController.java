package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.User_role;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating User
	@PostMapping("/")
	public User createuser(@RequestBody User user) throws Exception {
		user.setProfile("Defalut.png");
		
		//Encoding Passwrod with BCryptpasswordEncoder()
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<User_role> roles = new HashSet<>();
		
		Role role = new Role();
		role.setId(44L);
		role.setRoleName("NORMAl");
		
		User_role userRole = new User_role();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		
		return this.uService.createUser(user, roles);
	}
	
	//get user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return uService.getUserByusername(username);
	}
	
	//delete by user id
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long id) {
		uService.deleteByid(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//update API 

	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException e){
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.FOUND);
	}
	
	
}
