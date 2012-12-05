package com.demo.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.User;
import com.demo.pageable.SimplePageableImpl;


/**
 * Spring Data JPA 提供不同的查询方式
 * http://static.springsource.org/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 * a) Query lookup strategies
 * b) Query creation				在接口中定义方法名,由Spring-data-jpa帮我们实现,满足基本需要不够灵活
 * c) Using JPA NamedQueries		仅适用于小范围使用
 * 		XML named query definition
 * 		Annotation configuration
 * d) @Query Annotation
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:orm-jpa-context.xml"})
@Transactional
public class UserDaoTest {

	@Before
	public void before(){
		System.out.println("\n------------------------ 管凯吧tieba.baidu.com/gk ------------------------\n\n ");
	}
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * Using Query Creation
	 * testCount
	 * testFindOne
	 * testFindByName
	 * testFindByNameAndUsername
	 * testFindByNameStartingWith
	 * testFindByNameContaining
	 * testFindAll
	 * 
	 * Using JPA NamedQueries
	 * byNameQuery()
	 * byNamedNativeQuery
	 * 
	 * Using @Query & Using Name Parameter
	 * testQueryBySerial_
	 * testQueryBySerial
	 * 
	 */
	

	/**
	 * Using Query Creation
	 */
	@Test
	public void testCount(){
		System.out.println(userDao.count());
	}
	
	@Test
	public void testFindOne() {	
		User user = userDao.findOne(1);
		System.out.println(user);
		System.out.println(user.getDept());
	}
	

	@Test
	public void testFindByName() {
		User user = userDao.findByName("9527");

		System.out.println(user);
	}
	
	
	@Test
	public void testFindByNameAndUsername() {
		User user = userDao.findByNameAndUsername("9527", "9527");

		System.out.println(user);
	}
	
	
	@Test
	public void testFindByNameStartingWith() {
		List<User> users = userDao.findByNameStartingWith("管");

		for(User user:users){
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testFindByNameContaining() {
		List<User> users = userDao.findByNameContaining("一");

		for(User user:users){
			System.out.println(user);
		}
	}
	
	//如果你想查询第一页，应该new PageRequest(0,10)
	@Test
	public void testFindAll() {
		Page<User> users = userDao.findAll(new PageRequest(0,10) );
		
		for(User user:users.getContent()){
			System.out.println(user);
		}
		
	}
	
	
	
	/**
	 * Using JPA NamedQueries
	 */
	@Test
	public void byNameQuery() {
		User user = userDao.byNamedQuery();
		System.out.println(user);
	}
	
	@Test
	public void byNamedNativeQuery() {
		User user = userDao.byNamedNativeQuery();
		System.out.println(user);
	}

	
	/**
	 * Using @Query & Using Nnamed parameters
	 */
	@Test
	public void testQueryBySerial_(){
		User user = userDao.queryBySerial_("5000006");
		System.out.println(user);
	}

	@Test
	public void testQueryBySerial(){
		User user = userDao.queryBySerial("5000006");
		System.out.println(user);

	}
	
	
	
	
	
	//-----------------------------------------------------------------------------
	
	
	
	//这个自己 实现pageable接口不能用..
	//@Test
	public void test() {
		System.out.println("\n------------ output ------------\n ");
		Page<User> users = userDao.findAll(SimplePageableImpl.getInstance(3) );
		
	}
		
	
	
	

}
