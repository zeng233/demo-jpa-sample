package com.demo.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Dept;
import com.demo.domain.Role;
import com.demo.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:orm-jpa-context.xml"})
@Transactional
public class LazyInitializationTest {

	@Autowired
	private DeptDao deptDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("\n------------------------ 管凯吧 tieba.baidu.com/gk ------------------------\n\n");
	}

	//-----------------------ManyToOne-----------------------------------------
	/** 
	 * 测试Dept
	 * LAZY 和 EAGER 的设置问题?默认问题 ?
	 */
	//@Test
	public void testOneToMany() {	
		Dept dept = deptDao.findOne(1);
		System.out.println(dept);

	}
	
	
	/**
	 * 测试User
	 * 如果这里user.getDept() 
	 * dept的toString()被重写为 return ToStringBuilder.reflectionToString(this);
	 * 
	 * 测试就挂了，把部门下的人又全都带了出来
	 */
	//@Test
	public void testManyToOne(){
		User user = userDao.findOne(1);
		System.out.println(user);
		System.out.println(user.getDept());
		
	}
	
	//-----------------------ManyToMany-----------------------------------------
	/**
	 * 测试User & Role
	 */
	@Test
	public void testManyToMany(){
		User user = userDao.findOne(1);
		System.out.println(user);
		
		Role role = roleDao.findOne(1);
		System.out.println(role);	
	}
}
