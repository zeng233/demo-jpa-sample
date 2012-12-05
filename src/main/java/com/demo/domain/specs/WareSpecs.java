package com.demo.domain.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.demo.domain.Ware;
import com.demo.form.WareForm;

public class WareSpecs {
	
	
	/**
	 * 注意几个地方
	 * final WareForm form									final
	 * Path<Integer> betweenPrice = root.get("price");		Path<Integer>
	 */
	public static Specification<Ware> search(final WareForm form){
		
		return new Specification<Ware>() {
			
			@Override
			public Predicate toPredicate(Root<Ware> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				
				//多个条件
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				//条件1 价格
				Path<Integer> price = root.get("price");
				predicateList.add( builder.between(price, form.getLowPrice(),form.getHighPrice()));

				
				//条件2 名称
                Path<String> wname = root.get("wname");
                predicateList.add(  builder.like(wname, "%"+form.getWname()+"%") ); 
                
                return predicateList.isEmpty()?builder.conjunction():
                	builder.and(predicateList.toArray(new Predicate[predicateList.size()]) );
                
				
			}
		};
	}
	

}
