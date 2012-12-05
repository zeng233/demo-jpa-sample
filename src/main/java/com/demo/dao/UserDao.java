package com.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.demo.domain.User;


public interface UserDao extends Repository<User, Integer>{

	//Using Query Creation
	long count();
	
	User findOne(Integer id);

	User findByName(String name);

	User findByNameAndUsername(String name,String username);
	
	List<User> findByNameStartingWith(String name);
	
	List<User> findByNameContaining(String name);
	
	Page<User> findAll(Pageable pageable);
	
	User save(User user);
	
	
	
	//Using JPA NamedQueries
	User byNamedQuery();
	User byNamedNativeQuery();
	

	
	//查询多个?
	//Using @Query & Using Named Parameters
	@Query("from User u where u.serial = ?1 ")
	User queryBySerial_(String serial);
	
	@Query("from User u where u.serial = :serial")
	User queryBySerial(@Param("serial") String serial);
	
	
	
	//Using Sort(sort参数 或者 pageable中设置sort)
	List<User> findByNameStartingWith(String name,Sort sort);
	List<User> findByNameStartingWith(String name,Pageable pageable);
	
//	@Query("from User")
//	List<User> findAll_1(Sort sort);
//	
//	@Query("from User")
//	Page<User> findAll_2(Pageable pageable);

	
	
}
