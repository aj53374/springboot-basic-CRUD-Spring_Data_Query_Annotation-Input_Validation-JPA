package com.abhishek.restful.webservices.restfulservice.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.abhishek.restful.webservices.restfulservice.model.User;
import com.abhishek.restful.webservices.restfulservice.repo.UserRepo;
import com.abhishek.restful.webservices.restfulservice.repo.UsrRepository;

@Component
public class Dao {

	@Autowired
	private UsrRepository userRepo;
	
	public User save(User user) {
		return userRepo.save(user);
		
	}
	
	public List<User> getAll(){
		
		return userRepo.findAll();
	}	
	public Optional<User> getById(int id) {
		
		return userRepo.findById(id);
	}
	
	public void deleteById(int id) {
		
		userRepo.deleteById(id);
	}
	
	public void updatebyId(String empName,Date DoB,Integer id) {
		
		userRepo.update(empName,DoB,id);
	
	}
}
