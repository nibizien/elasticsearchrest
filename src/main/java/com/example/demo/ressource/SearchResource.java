package com.example.demo.ressource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

	@Autowired
	UsersRepository	usersRepository;
	
	@GetMapping(value = "/name/{text}")
	public List<Users> searchName(@PathVariable final String text){
		return usersRepository.findByName(text);
		
	}
	
	@GetMapping(value = "/salary/{salary}")
	public List<Users> searchSalary(@PathVariable final String salary){
		return usersRepository.findBySalary(salary);
		
	}
	
	@GetMapping(value = "/all")
	public List<Users> searchAll(){
		List<Users> allUsers = new ArrayList<>();
		Iterable<Users> users =  usersRepository.findAll();
		
		//users.forEach(allUsers::add);
		
		
		users.forEach(user -> {
			allUsers.add(user);
		});
		return allUsers;
	}
	
}
