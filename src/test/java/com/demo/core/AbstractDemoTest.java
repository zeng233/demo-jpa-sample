package com.demo.core;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

public class AbstractDemoTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@BeforeTransaction
	public void setUp(){
		System.out.println("executeSqlScript");
		executeSqlScript("classpath:data.sql", false);
	}
	

}
