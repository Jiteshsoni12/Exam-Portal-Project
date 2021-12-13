package com.exam.service;

import java.util.Set;

import com.exam.model.User;
import com.exam.model.User_role;

public interface UserService {
	
	//creating User
	public User createUser(User user, Set<User_role> userRoles) throws Exception;
	
	//get user by username
	public User getUserByusername(String username);
	
	//delete by user id
	public void deleteByid(Long id);
	
}
