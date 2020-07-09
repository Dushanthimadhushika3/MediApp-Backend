package com.example.mediapp.user;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mediapp.Role.Role;
import com.example.mediapp.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByEmailAndRoles(String email, Role role);
	public User findByName(String name);
	public User findByUid(Long uid);
	public List<User> findByGradeAndClzAndRoles(Integer grade, String clz, Role role);
	User findByIndexNo(String indexNo);
	User getUserByRoles(List<Role> roles);
    List<User> findByRoles(List<Role> roles);
    
}



