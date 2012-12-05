package com.demo.pageable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class SimplePageableImpl implements Pageable {

	private int pageNumber;
	
	//设置单例模式,获得对象
	private SimplePageableImpl(int pageNumber){
		this.pageNumber = pageNumber;
	}
	
	public static Pageable getInstance(int pageNumber){
		return new SimplePageableImpl(pageNumber);
	}
	
	

	@Override
	public int getOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPageNumber() {
		// TODO Auto-generated method stub
		return this.pageNumber;
	}

	@Override
	public int getPageSize() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

}
