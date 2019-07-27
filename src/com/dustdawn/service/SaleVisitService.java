package com.dustdawn.service;

import org.hibernate.criterion.DetachedCriteria;

import com.dustdawn.entity.SaleVisit;
import com.dustdawn.utils.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	SaleVisit getById(Long long1);
}
