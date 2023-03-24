package com.fullstackems.fullStackEmsBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackems.fullStackEmsBackend.Repository.UserRepository;
import com.fullstackems.fullStackEmsBackend.exception.UserNotFoundException;
import com.fullstackems.fullStackEmsBackend.model.User;

@RestController
@CrossOrigin(origins="http://localhost:3001")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/postuser")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser); 
		}
	@GetMapping("/getusers")
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/getuser/{id}")
	User getUserById(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}
	
	@PutMapping("/updateuser/{id}")
	User updateUser(@RequestBody User newUser,@PathVariable long id) {
		return userRepository.findById(id)
				.map(user -> {
					user.setUsername(newUser.getUsername());
					user.setName(newUser.getName());
					user.setEmail(newUser.getEmail());
					
					return userRepository.save(user);
				}).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@DeleteMapping("/deleteuser/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!userRepository.existsById(id)) {
			 throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
		return "User with id "+id+" has been deleted successfully.";
	}


}
