package com.abhishek.restful.webservices.restfulservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.restful.webservices.restfulservice.dao.Dao;
import com.abhishek.restful.webservices.restfulservice.model.User;
import com.abhishek.restful.webservices.restfulservice.repo.UserRepo;

@RestController
public class Controller {

	@Autowired
	private Dao dao;
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		
		User usr=dao.save(user);
		return ResponseEntity.created(null).body("User With ID:"+usr.getEmpId()+" and Name:"+usr.getEmpName()+" Created");
		}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
	
		List<User> usrList=dao.getAll();
		return ResponseEntity.ok().body(usrList);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getUserbyId(@PathVariable("id") int id) {
	
		 Optional<User> usr = dao.getById(id);
		if(!usr.isPresent())
		 return ResponseEntity.notFound().build();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(usr);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deletebyId(@PathVariable("id") int id) {
		
		//Check if user exists or Not.
		Optional<User> usr = dao.getById(id);
		if(!usr.isPresent()) {
		// return ResponseEntity.notFound().build();  //returns only Header "Not found"
			
			//returns header not found with custom message
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID:"+id+" Not Found");
		}
		 return ResponseEntity.status(HttpStatus.FOUND).body("User with ID:"+id+" Successfully Deleted");
		
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> update(@Valid @PathVariable("id") int id,@RequestBody User user ) {
		
		//Check if user exists or Not.
				Optional<User> usr = dao.getById(id);
				
				if(!usr.isPresent()) {
				// return ResponseEntity.notFound().build();  //returns only Header "Not found"
					
					//returns header not found with custom message
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID:"+id+" Not Found");
				}
		
				
				dao.updatebyId(user.getEmpName(),user.getDoB(),id);
			
				return  ResponseEntity.ok().body("User with ID:"+id+" Updated");
		
	}
	


}
