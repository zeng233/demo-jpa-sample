package com.demo.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Ware;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:orm-jpa-context.xml"})
@Transactional
public class WareServiceTest {
	
	@Autowired
	private WareService wareService;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testFindOne(){
		Ware ware = wareService.findOne(1);
		System.out.println(ware);
	}
	
	
	
}
