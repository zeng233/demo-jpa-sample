package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.domain.Ware;
import com.demo.service.WareService;


@Controller
@RequestMapping("/wares")
public class WareController {

	
	@Autowired
	private WareService wareService;
	
	
	/**
	 * 以前的做法
	 */

	
//	@RequestMapping("/{wid}")
//	public String get(@PathVariable("wid") Integer wid ,Model model){
//		model.addAttribute("ware", wareService.findByWid(wid));
//		return "ware";
//	}
	
	/**
	 * http://localhost:8088/demo-jpa-sample/wares/func1?page=1&pageSize=15
	 */
	@RequestMapping(value="/func1")
	public String list(HttpServletRequest request,Model model){
		
	    int page = Integer.parseInt(request.getParameter("page"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	    List<Ware> wareList = wareService.findAll(new PageRequest(page-1,pageSize)).getContent();
	    
	    model.addAttribute("wares", wareList);
	    return "wares";
		
	}
	
	/**
	 * PageableArgumentResolver 
	 * 
	 * http://static.springsource.org/spring-data/data-jpa/docs/1.1.0.RELEASE/reference/html/#web-pagination
	 * http://localhost:8088/demo-jpa-sample/wares/func2?page.page=3&page.size=10&page.sort=price&page.sort.dir=desc
	 * 
	 * P.S
	 * 参考doc,page参数谁尼玛知道会这样用page.page=3?
	 * 注意SQL语句中有分页,没有排序
	 */
	@RequestMapping(value="/func2")
	public String list_(Pageable pageable,Model model){
		model.addAttribute("wares", wareService.findAll(pageable).getContent());
		return "wares";
	}
	
	
	/**
	 * PropertyEditors
	 */
	@RequestMapping("/{wid}")
	public String get_(@PathVariable("wid") Ware ware,Model model){
		//populate model?
		
		return "ware";
	}
	
	
	
	
	
	
	
	
}
