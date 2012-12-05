package com.demo.dao;

import org.springframework.data.repository.Repository;

import com.demo.domain.Role;

public interface RoleDao extends Repository<Role, Integer>{
		
	Role findOne(Integer id);
	
}
