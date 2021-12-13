package com.exam.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.exam.helper.*;
import com.exam.model.User;
import com.exam.model.User_role;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo; 
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public User createUser(User user, Set<User_role> userRoles) throws Exception{
		User local = this.userRepo.findByUsername(user.getUsername());
		if(local!=null) 
		{
			System.out.println("User Already Present!!");
			throw new UserFoundException(); 
		}else {
			//har ek role ko nikal ke fir save kiya
			for(User_role ur:userRoles) {
				roleRepo.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepo.save(user);
		}
		return local;
	}

	
	//get user by username
	@Override
	public User getUserByusername(String username) {
		User local = this.userRepo.findByUsername(username);
		return local;
	}


	@Override
	public void deleteByid(Long id) {
		this.userRepo.deleteById(id);
		
	}

}
