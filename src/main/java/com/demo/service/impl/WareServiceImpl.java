package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.dao.WareDao;
import com.demo.domain.Ware;
import com.demo.service.WareService;


@Service
public class WareServiceImpl implements WareService {

	@Autowired
	private WareDao wareDao;
	
	@Override
	public Page<Ware> findAll(Specification<Ware> specification,
			Pageable pageable) {
		return wareDao.findAll(specification, pageable);
	}

	@Override
	public Page<Ware> findAll(Pageable pageable) {
		return wareDao.findAll(pageable);
	}

	@Override
	public Ware findOne(int id) {
		return wareDao.findOne(id);
	}

	@Override
	public Ware findByWid(Integer wid) {
		return wareDao.findByWid(wid);
	}

}
