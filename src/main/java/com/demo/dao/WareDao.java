package com.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.demo.domain.Ware;

public interface WareDao extends Repository<Ware, Integer> {

	Page<Ware> findAll(Pageable pageable);
	
	Page<Ware> findAll(Specification<Ware> specification,Pageable pageable);
	
	Ware findOne(Integer id);
	
	Ware findByWid(Integer wid);
	

	
}
