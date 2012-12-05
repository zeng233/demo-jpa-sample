package com.demo.dao;

import org.springframework.data.repository.Repository;

import com.demo.domain.Dept;

public interface DeptDao extends Repository<Dept, Integer>{
		
	Dept findOne(Integer deptid);

}
