package com.example.demo.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.demo.model.Users;

public interface UsersRepository extends ElasticsearchRepository <Users,Long>{
	
	List<Users> findByName(String text);
	
	List<Users> findBySalary(String salary);

}
