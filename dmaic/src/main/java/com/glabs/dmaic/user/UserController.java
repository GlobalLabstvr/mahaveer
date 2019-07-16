package com.glabs.dmaic.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvr.training.api.subject.Subject;

@RestController

public class UserController {

@Autowired
private UserRepository userRepository;

public UserRepository getRepository() {
	return userRepository;
}

public void setRepository(UserRepository repository) {
	this.userRepository = repository;
}

@GetMapping(value = "/users")
public Optional<User> getAllsubjects(
		@RequestParam(value="name",required=false) Long userId ) {
    Optional<User> list = new ArrayList()<User>();
	if(userId!=null && !id.equals("")) {
    	list = UserRepository.findById(userId);
    }
	else {
		list =UserRepository.findAll();
	}
	return list;
}

@PostMapping("/users")
User createOrSaveUser(@RequestBody User newUser) {
	return userRepository.save(newUser);
}

@GetMapping("/users/{id}")
	User getUserById(@PathVariable Long userId) {
	return userRepository.findById(userId).get();
}

@PutMapping("/users/{id}")
User updateUser(@RequestBody User newUser, @PathVariable Long userId) {
	 
    return userRepository.findById(userId).map(user -> {
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        return userRepository.save(user);
    }).orElseGet(() -> {
        newUser.setId(userId);
        return userRepository.save(newUser);
    });
}

@DeleteMapping("/users/{id}")
void deleteUser(@PathVariable Long userId) {
	userRepository.deleteById(userId);
}
}
