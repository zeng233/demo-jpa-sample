package com.demo.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Ware;
import com.demo.domain.specs.WareSpecs;
import com.demo.form.WareForm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:orm-jpa-context.xml"})
@Transactional
public class SpecificationTest {

	@Autowired
	private WareDao	wareDao;

	
	@Before
	public void setUp() throws Exception {
		System.out.println("\n------------------------ 管凯吧 tieba.baidu.com/gk ------------------------\n\n");
	}
	
	
	@Test
	public void aa(){
		
		//设置wareform
		WareForm form = new WareForm();
		form.setLowPrice(20);
		form.setHighPrice(100);
		form.setWname("");
		
		Page<Ware> wares =  wareDao.findAll( WareSpecs.search(form),new PageRequest(0,5));
		for (Ware ware : wares.getContent()) {
			System.out.println(ware);
		}
	}

	
}
