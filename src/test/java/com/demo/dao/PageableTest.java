package com.demo.dao;

import java.util.List;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:orm-jpa-context.xml"})
@Transactional
public class PageableTest {

	@Before
	public void before(){
		System.out.println("\n------------------------ 管凯吧tieba.baidu.com/gk ------------------------\n\n ");
	}
	
	@Autowired
	private UserDao userDao;
	
	
	/**
	 * Using Sort & Pageable
	 * 
	 * 1.Pageable, Sort 不能一起使用,排序可通过 new PageRequest(page,page.size,page.sort.dir, page.sort)
	 * Method must not have Pageable *and* Sort parameter. Use sorting capabilities on Pageble instead! 
	 * 
	 * 2. Query creation 方法中加Pageable参数就会报错
	 * [ Your persistence provider does not support extracting the JPQL query from a named query 
	 * 	thus you can't use Pageable inside your query method ]
	 * 
	 * 在orm-jpa-context配置 entityManagerFactory- jpaVendorAdapter
	 * 
	 * 
	 * 
	 */
	@Test
	public void testPageable(){
		

		/**
		 * 
		 * new PageRequest(int page,int size,Direction direction,String... properties))
		 *  
		 * ...
		 * order by
         *	user0_.serial asc fetch first 5 rows only
		 */
		List<User> users1 = userDao.findByNameStartingWith("兰", new PageRequest(0,5,Direction.ASC, "serial") );
		for (User user : users1) {
			System.out.println(user);
		}
		
		
		

		/**
		 * new PageRequest(int page,int size,Sort sort))
		 * 
		 * 
		 * ...
		 * order by
         *	user0_.serial asc,
         *	user0_.userid desc fetch first 5 rows only
		 */
		List<User> users2 = userDao.findByNameStartingWith("兰", 
					new PageRequest(0,5,new Sort( new Order(Direction.ASC, "serial"),new Order(Direction.DESC, "userid") ))
				);  
		for (User user : users2) {
			System.out.println(user);
		}
		
		
		/**
		 * new Sort(Direction direction, String properties)
		 */
		List<User> users3 = userDao.findByNameStartingWith("兰", new Sort(Direction.ASC, "serial"));
		for (User user : users3) {
			System.out.println(user);
		}
	}

}
