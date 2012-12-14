package com.demo.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.demo.core.AbstractDemoTest;
import com.demo.domain.User;

@ContextConfiguration(locations={"classpath:orm-jpa-context.xml"})
public class HSQLDBTest extends AbstractDemoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testFindOne(){
		User user = userDao.findOne(1);
		System.out.println(user);
	}
	
}
