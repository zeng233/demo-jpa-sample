package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.demo.domain.Ware;

public interface WareService {
	
	Page<Ware> findAll(Pageable pageable);
	
	Page<Ware> findAll(Specification<Ware> specification,Pageable pageable);
	
	Ware findOne(int id);
	
	Ware findByWid(Integer wid);
	
	

}
