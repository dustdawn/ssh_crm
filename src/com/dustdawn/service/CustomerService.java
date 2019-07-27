package com.dustdawn.service;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dustdawn.entity.Customer;
import com.dustdawn.utils.PageBean;

public interface CustomerService {
	//分页业务
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存
	void save(Customer customer);
	Customer getById(Long cust_id);
	//获得按行业统计数量
	List<Object[]> getIndustryCount();
}
