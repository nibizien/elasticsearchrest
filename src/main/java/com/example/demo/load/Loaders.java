package com.example.demo.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Component
public class Loaders {

	@Autowired
	ElasticsearchOperations operations;
	
	@Autowired
	UsersRepository usersRepository;
	
	@PostConstruct
	@Transactional
	public void loadAll(){
		
		operations.putMapping(Users.class);
		System.out.println("Loading data");
		usersRepository.save(getData());
		System.out.println("Load complete");
	}

	private List<Users> getData() {
		List<Users> allusers = new ArrayList<>();
		allusers.add(new Users("Jean",123L,"account",1200L));
		allusers.add(new Users("Paul",124L,"finance",3200L));
		allusers.add(new Users("Anne",123L,"account",2200L));
		return allusers;
	}
	
}
