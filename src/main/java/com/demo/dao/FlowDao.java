package com.demo.dao;

import org.springframework.data.repository.Repository;

import com.demo.domain.Flow;

public interface FlowDao extends Repository<Flow, Integer>{
	
	Flow findOne(Integer id);
	
	Flow save(Flow flow);
	

}


